package com.incrzero.sse;

import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jiangdongzhao
 */
@RestController
public class TemperatureController {
    private final CopyOnWriteArrayList<SseEmitter> clients = new CopyOnWriteArrayList();

    @GetMapping("/temperature")
    public SseEmitter event() {

        SseEmitter sseEmitter = new SseEmitter();
        clients.add(sseEmitter);
        sseEmitter.onTimeout(() -> clients.remove(sseEmitter));
        sseEmitter.onCompletion(() -> clients.remove(sseEmitter));
        return sseEmitter;
    }

    @EventListener
    public void handleMessage(Temperature temperature) {
        List<SseEmitter> deadEmitters = new ArrayList<>();

        clients.forEach(c -> {
            try {
                c.send(temperature);
            } catch (Exception e) {
                deadEmitters.add(c);
            }
        });

        clients.removeAll(deadEmitters);
    }
}

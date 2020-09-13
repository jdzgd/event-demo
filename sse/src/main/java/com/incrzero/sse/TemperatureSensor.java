package com.incrzero.sse;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangdongzhao
 */
@Component
public class TemperatureSensor {
    private final ApplicationEventPublisher publisher;
    private final Random random = new Random();
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public TemperatureSensor(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostConstruct
    public void init() {
        this.probe();
    }

    private void probe() {
        double value = 26 + random.nextGaussian() * 10;
        Temperature temperature = new Temperature(value);
        publisher.publishEvent(temperature);
        executorService.schedule(this::probe, random.nextInt(5000), TimeUnit.MILLISECONDS);
    }
}

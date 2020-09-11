package com.incrzero.application;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 用户监听
 *
 * @author jiangdongzhao
 */
@Component
public class UserListener {

    @EventListener
    public void processNews(AppleNewsEvent event) {
        System.out.println(event.getMessage());
    }

}

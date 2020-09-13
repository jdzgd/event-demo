package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author jiangdongzhao
 */
@Component
public class ApplePublisher {

    @Autowired
    ApplicationEventPublisher publisher;

    public void publish() {
        publisher.publishEvent(new AppleNewsEvent(this, "今天天气很好"));
    }

}

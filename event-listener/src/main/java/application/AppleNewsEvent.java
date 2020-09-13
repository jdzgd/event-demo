package application;

import org.springframework.context.ApplicationEvent;

/**
 * AppleNewsEvent
 *
 * @author jiangdongzhao
 */
public class AppleNewsEvent extends ApplicationEvent {

    private String message;

    public AppleNewsEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

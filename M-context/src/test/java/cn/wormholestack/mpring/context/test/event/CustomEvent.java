package cn.wormholestack.mpring.context.test.event;

import cn.wormholestack.mpring.context.event.ApplicationContextEvent;

/**
 * @description： CustomEvent
 * @Author MRyan
 * @Date 2021/9/19 10:50
 * @Version 1.0
 */
public class CustomEvent extends ApplicationContextEvent {

    private Long id;

    private String message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
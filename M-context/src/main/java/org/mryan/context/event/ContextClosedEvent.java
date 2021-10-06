package org.mryan.context.event;

/**
 * @description： ContextClosedEvent
 * @Author MRyan
 * @Date 2021/9/19 09:20
 * @Version 1.0
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}

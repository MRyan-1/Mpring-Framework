package org.mryan.context.test.event;

import java.util.EventObject;

/**
 * @description： 事件
 * @Author MRyan
 * @Date 2021/9/19 09:10
 * @Version 1.0
 */
public class ApplicationEvent extends EventObject {

    private final long timestamp;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
        this.timestamp = System.currentTimeMillis();
    }

    public final long getTimestamp() {
        return timestamp;
    }
}

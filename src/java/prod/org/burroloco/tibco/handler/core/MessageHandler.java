package org.burroloco.tibco.handler.core;

import edge.com.tibco.tibrv.TibrvListener;
import edge.com.tibco.tibrv.TibrvMsg;

public interface MessageHandler {
    void onMsg(TibrvListener listener, TibrvMsg message);
}

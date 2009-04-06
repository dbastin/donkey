package org.burroloco.tibco.handler.core;

import au.net.netstorm.boost.bullet.log.Log;
import edge.com.tibco.tibrv.TibrvListener;
import edge.com.tibco.tibrv.TibrvMsg;

public class LoggingMessageHandler implements MessageHandler {
    MessageHandler delegate;
    Log log;

    public void onMsg(TibrvListener listener, TibrvMsg msg) {
        log.trace("Received on " + listener.getSubject() + ": " + format(msg));
        delegate.onMsg(listener, msg);
    }

    private String format(TibrvMsg msg) {
        String result = msg.toString();
        result = result.replaceAll("KPLUSFEED=", "\nKPLUSFEED=");
        result = result.replaceAll("Table=", "\n\nTable=");
        return result;
    }

}

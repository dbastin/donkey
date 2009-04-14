package org.burroloco.tibco.handler.edge;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import edge.com.tibco.tibrv.TibrvListener;
import edge.com.tibco.tibrv.TibrvMsg;
import org.burroloco.tibco.handler.core.MessageHandler;

// WARNING: Please do nothing other than delegating in this class!
// FIX TSR-DONKEY Use or Lose
public class DefaultEdgeMessageHandler implements EdgeMessageHandler {
    private final MessageHandler delegate;
    Edges edger;

    public DefaultEdgeMessageHandler(MessageHandler delegate) {
        this.delegate = delegate;
    }

    public void onMsg(com.tibco.tibrv.TibrvListener listener, com.tibco.tibrv.TibrvMsg msg) {
        delegate.onMsg(edge(listener), edge(msg));
    }

    private TibrvListener edge(com.tibco.tibrv.TibrvListener listener) {
        return edger.edge(TibrvListener.class, listener);
    }

    private TibrvMsg edge(com.tibco.tibrv.TibrvMsg msg) {
        return edger.edge(TibrvMsg.class, msg);
    }
}

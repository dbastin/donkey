package org.burroloco.tibco.dispatcher;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import com.tibco.tibrv.TibrvMsgCallback;
import edge.com.tibco.tibrv.TibrvDispatcher;
import edge.com.tibco.tibrv.TibrvListener;
import edge.com.tibco.tibrv.TibrvQueue;
import static org.burroloco.tibco.common.TibcoConstants.NO_CLOSURE;
import org.burroloco.tibco.factory.TibcoFactory;
import org.burroloco.tibco.handler.core.MessageHandler;
import org.burroloco.tibco.handler.edge.EdgeMessageHandler;
import org.burroloco.tibco.transport.TibcoTransport;

public class DefaultTibcoDispatcherFactory implements TibcoDispatcherFactory {
    TibcoFactory factory;
    Nu nu;

    public TibcoDispatcher nu(TibcoTransport transport, String subject, MessageHandler handler) {
        TibrvQueue queue = factory.queue();
        TibrvDispatcher dispatcher = factory.dispatcher(queue);
        listener(transport, queue, handler, subject);
        return nu.nu(TibcoDispatcher.class, dispatcher);
    }

    private void listener(TibcoTransport transport, TibrvQueue queue, MessageHandler handler, String subject) {
        TibrvMsgCallback callback = nu.nu(EdgeMessageHandler.class, handler);
        nu.nu(TibrvListener.class, queue, callback, transport.tibby(), subject, NO_CLOSURE);
    }
}

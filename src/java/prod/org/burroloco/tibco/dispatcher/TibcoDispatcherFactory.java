package org.burroloco.tibco.dispatcher;

import org.burroloco.tibco.handler.core.MessageHandler;
import org.burroloco.tibco.transport.TibcoTransport;

public interface TibcoDispatcherFactory {
    TibcoDispatcher nu(TibcoTransport transport, String subject, MessageHandler handler);
}

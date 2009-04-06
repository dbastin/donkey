package org.burroloco.tibco.factory;

import edge.com.tibco.tibrv.TibrvDispatcher;
import edge.com.tibco.tibrv.TibrvQueue;
import org.burroloco.tibco.transport.TibcoTransport;

public interface TibcoFactory {
    TibrvQueue queue();

    TibrvDispatcher dispatcher(TibrvQueue queue);

    TibcoTransport transport();
}

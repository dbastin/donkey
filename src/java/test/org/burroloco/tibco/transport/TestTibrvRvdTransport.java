package org.burroloco.tibco.transport;

import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvRvdTransport;

public interface TestTibrvRvdTransport extends TibrvRvdTransport {
    TibrvMsg get();
}

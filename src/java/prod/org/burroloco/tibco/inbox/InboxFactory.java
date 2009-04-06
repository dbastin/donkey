package org.burroloco.tibco.inbox;

import org.burroloco.tibco.transport.TibcoTransport;

public interface InboxFactory {
    Inbox nu(TibcoTransport transport);
}

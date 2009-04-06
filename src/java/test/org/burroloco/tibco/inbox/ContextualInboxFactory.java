package org.burroloco.tibco.inbox;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.tibco.transport.TibcoTransport;

public class ContextualInboxFactory implements InboxFactory {
    private final String context;
    InboxFactory delegate;
    Weaken weaken;
    Nu nu;

    public ContextualInboxFactory(String context) {
        this.context = context;
    }

    public Inbox nu(TibcoTransport transport) {
        Inbox inbox = delegate.nu(transport);
        return nu.nu(Inbox.class, weaken.w(inbox) + "_" + context);
    }
}

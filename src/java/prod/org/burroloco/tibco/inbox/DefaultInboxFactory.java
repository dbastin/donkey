package org.burroloco.tibco.inbox;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.tibco.transport.TibcoTransport;

public class DefaultInboxFactory implements InboxFactory {
    LocalHost host;
    Nu nu;

    public Inbox nu(TibcoTransport transport) {
        String i = transport.createInbox() + "." + host.shortName();
        return nu.nu(Inbox.class, i);
    }
}

package org.burroloco.tibco.transport;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.com.tibco.tibrv.TibrvRvdTransport;
import org.burroloco.tibco.config.Daemon;
import org.burroloco.tibco.config.Network;
import org.burroloco.tibco.config.Service;

public class DefaultTibcoTransportFactory implements TibcoTransportFactory {
    Service service;
    Network network;
    Daemon daemon;
    Weaken weaken;
    Nu nu;

    public TibcoTransport nu() {
        // Creating a transport causes those "license will expire" messages even though we are not starting a local rvd.
        TibrvRvdTransport t = nu.nu(TibrvRvdTransport.class, weaken.w(service), weaken.w(network), weaken.w(daemon));
        return nu.nu(TibcoTransport.class, t);
    }
}

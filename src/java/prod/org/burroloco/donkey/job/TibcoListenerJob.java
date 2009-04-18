package org.burroloco.donkey.job;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.Subject;
import org.burroloco.tibco.dispatcher.TibcoDispatcher;
import org.burroloco.tibco.dispatcher.TibcoDispatcherFactory;
import org.burroloco.tibco.factory.LifecycleTibcoFactory;
import org.burroloco.tibco.handler.core.MessageHandler;
import org.burroloco.tibco.transport.TibcoTransport;

public class TibcoListenerJob implements Job {
    TibcoDispatcherFactory dispatchers;
    LifecycleTibcoFactory tibby;
    MessageHandler handler;
    Subject subject;
    Weaken weak;

    public void go(Config config) {
        TibcoTransport transport = tibby.transport();
        String s = weak.w(subject);
        TibcoDispatcher dispatcher = dispatchers.nu(transport, s, handler);
        dispatcher.join();
    }
}

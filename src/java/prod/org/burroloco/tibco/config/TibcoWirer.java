package org.burroloco.tibco.config;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.wire.ConfigRegistrar;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.tibco.factory.DefaultLifecycleTibcoFactory;
import org.burroloco.tibco.factory.LifecycleTibcoFactory;
import org.burroloco.tibco.factory.TibcoFactory;
import org.burroloco.tibco.handler.core.LoggingMessageHandler;
import org.burroloco.tibco.handler.core.MessageHandler;

public class TibcoWirer implements Wirer {
    ConfigRegistrar registrar;
    Wire wire;
    Nu nu;

    public void wire(Config config) {
        strong(config);
        handler();
        factory();
    }

    private void strong(Config config) {
        registrar.register(config, Network.class);
        registrar.register(config, Daemon.class);
        registrar.register(config, Service.class);
    }

    private void handler() {
        wire.cls(LoggingMessageHandler.class).to(MessageHandler.class);
    }

    private void factory() {
        wire.cls(DefaultLifecycleTibcoFactory.class).one().to(LifecycleTibcoFactory.class).to(TibcoFactory.class);
    }

}

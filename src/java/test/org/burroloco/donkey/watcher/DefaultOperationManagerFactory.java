package org.burroloco.donkey.watcher;

import au.net.netstorm.boost.bullet.farmer.DefaultOperationManager;
import au.net.netstorm.boost.bullet.farmer.OperationManager;
import au.net.netstorm.boost.bullet.farmer.Timeout;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import static org.burroloco.test.constants.TestConstants.FIVE_SECONDS;

public class DefaultOperationManagerFactory implements OperationManagerFactory {
    Resolver resolver;
    Wire wire;

    public OperationManager nu() {
        wire.nu(Timeout.class, FIVE_SECONDS).to(Timeout.class, DefaultOperationManager.class);
        wire.cls(DefaultOperationManager.class).one().to(OperationManager.class);
        return resolver.resolve(OperationManager.class);
    }
}

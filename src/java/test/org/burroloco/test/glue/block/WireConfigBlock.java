package org.burroloco.test.glue.block;

import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlock;
import au.net.netstorm.boost.spider.api.config.aspect.Aspector;
import org.burroloco.config.loader.DefaultPropertiesLoader;
import org.burroloco.test.glue.layer.TokenReplaceLayer;

public class WireConfigBlock implements TestLifecycleBlock {
    Aspector aspector;

    public void execute() {
        aspector.cut(DefaultPropertiesLoader.class, TokenReplaceLayer.class);
    }
}

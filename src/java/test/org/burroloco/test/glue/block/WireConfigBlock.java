package org.burroloco.test.glue.block;

import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlock;
import au.net.netstorm.boost.spider.api.config.aspect.Aspector;
import org.burroloco.config.loader.DefaultConfigLoader;
import org.burroloco.config.loader.DefaultPropertiesLoader;
import org.burroloco.config.override.core.Overrides;
import org.burroloco.donkey.config.CompletedDirname;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.config.ErrorReportDirName;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.OutputDirName;
import org.burroloco.donkey.log.LoaderLogger;
import org.burroloco.test.glue.layer.OverrideConfigLayer;
import org.burroloco.test.glue.layer.TokenReplaceLayer;

public class WireConfigBlock implements TestLifecycleBlock {
    private static final Class[] DIR_CLASSES = {
            InputDirName.class,
            CompletedDirname.class,
            OutputDirName.class,
            ErrorDirName.class,
            ErrorReportDirName.class,
    };
    Overrides overrides;
    Aspector aspector;

    public void execute() {
        for (Class type : DIR_CLASSES) overrides.prefix(type, "gen/artifacts/test/");
        aspector.cut(DefaultConfigLoader.class, LoaderLogger.class, OverrideConfigLayer.class);
        aspector.cut(DefaultPropertiesLoader.class, TokenReplaceLayer.class);
    }
}

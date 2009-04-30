package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.LogEngine;
import au.net.netstorm.boost.spider.api.config.aspect.Aspector;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.loader.DefaultConfigLoader;
import org.burroloco.donkey.input.csv.DefaultCsvReader;
import org.burroloco.donkey.output.file.DefaultScribbler;
import org.burroloco.donkey.util.DefaultFileShifter;

public class LoggingWeb implements Web {
    Aspector a;
    Wire wire;

    public void web() {
        a.cut(DefaultConfigLoader.class, LoaderLogger.class);
        a.cut(DefaultScribbler.class, FileScribblerLogger.class);
        a.cut(DefaultFileShifter.class, FileMovingLogger.class);
        a.cut(DefaultCsvReader.class, FileReaderLogger.class);
        wire.cls(Slf4jLogEngine.class).to(LogEngine.class);
    }
}

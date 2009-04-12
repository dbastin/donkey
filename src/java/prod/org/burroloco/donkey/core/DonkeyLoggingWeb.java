package org.burroloco.donkey.core;

import au.net.netstorm.boost.spider.api.config.aspect.Aspector;
import au.net.netstorm.boost.spider.api.config.web.Web;
import org.burroloco.config.loader.DefaultConfigLoader;
import org.burroloco.donkey.input.csv.DefaultCsvReader;
import org.burroloco.donkey.log.FileMovingLogger;
import org.burroloco.donkey.log.FileReaderLogger;
import org.burroloco.donkey.log.FileScribblerLogger;
import org.burroloco.donkey.log.LoaderLogger;
import org.burroloco.donkey.log.TasterLogger;
import org.burroloco.donkey.output.file.DefaultScribbler;
import org.burroloco.donkey.util.DefaultFileShifter;

public class DonkeyLoggingWeb implements Web {
    Aspector a;

    public void web() {
        a.cut(DefaultTaster.class, TasterLogger.class);
        a.cut(DefaultConfigLoader.class, LoaderLogger.class);
        a.cut(DefaultScribbler.class, FileScribblerLogger.class);
        a.cut(DefaultFileShifter.class, FileMovingLogger.class);
        a.cut(DefaultCsvReader.class, FileReaderLogger.class);
    }
}

package org.burroloco.demo.watcher;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.csv.CsvSlurper;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.ShiftySpitter;
import org.burroloco.donkey.output.replacing.FileSpitter;
import org.burroloco.donkey.transformation.transform.PassThroughTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;

public class DirectoryWatcherWirer implements Wirer {
    Wire wire;

    //SIMIAN OFF
    public void wire(Config config) {
        wire.cls(CsvSlurper.class).to(Slurper.class);
        wire.cls(PassThroughTransform.class).to(Transform.class);
        wire.cls(ShiftySpitter.class).to(Spitter.class);
        wire.cls(FileSpitter.class).to(Spitter.class, ShiftySpitter.class);
    }
    //SIMIAN ON
}

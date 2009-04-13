package org.burroloco.demo.csv2sql;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.csv.CsvSlurper;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.replacing.FileSpitter;
import org.burroloco.donkey.transformation.transform.PassThroughTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;

public class CsvToSqlWirer implements Wirer {
    Wire wire;

    public void wire(Config config) {
        wire.cls(CsvSlurper.class).to(Slurper.class);
        wire.cls(PassThroughTransform.class).to(Transform.class);
        wire.cls(FileSpitter.class).to(Spitter.class);
    }
}

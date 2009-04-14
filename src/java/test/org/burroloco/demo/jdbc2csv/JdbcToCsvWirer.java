package org.burroloco.demo.jdbc2csv;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;

public class JdbcToCsvWirer implements Wirer {
    Wire wire;

    public void wire(Config config) {
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
        wire.cls(EmployeeTransform.class).to(Transform.class);
        wire.cls(CsvSpitter.class).to(Spitter.class);
    }
}

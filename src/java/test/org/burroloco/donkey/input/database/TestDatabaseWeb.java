package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.csv.CsvSlurper;
import org.burroloco.donkey.input.csv.DefaultListConverter;
import org.burroloco.donkey.input.csv.ListConverter;
import org.burroloco.util.wire.Dna;

public class TestDatabaseWeb implements Web {
    Wire wire;
    Dna dna;

    public void web() {
        wire.cls(CsvSlurper.class).to(Slurper.class);
        dna.strand(ListConverter.class, EmptyStringToDbNullListConverter.class, DefaultListConverter.class);
    }
}

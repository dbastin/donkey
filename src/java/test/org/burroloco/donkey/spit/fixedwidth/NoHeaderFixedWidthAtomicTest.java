package org.burroloco.donkey.spit.fixedwidth;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DataGenerator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;

public class NoHeaderFixedWidthAtomicTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private static final String EXPECTED = "1                        chocolate                meep                     " + LINE;
    private FixedWidthRecordStringer subject;
    private Data data;

    DataGenerator generator;
    Config configDummy;
    Nu nu;

    public void fixtures() {
        wire.cls(NoHeaderorFooterDefinition.class).to(FixedRecordDefinition.class);
        subject = nu.nu(FixedWidthRecordStringer.class);
        data = generator.data(1, 1, "chocolate");
    }

    public void testNoHeader() {
        String actual = subject.build(configDummy, data);
        assertEquals(EXPECTED, actual);
    }
}

package org.burroloco.donkey.output.fixedwidth;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Bakery;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class NoHeaderFixedWidthAtomicTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private static final String EXPECTED = "1                        chocolate                flour                    " + LINE;
    private FixedWidthRecordStringer subject;
    private Data data;
    Config configDummy;
    Bakery bakery;
    Nu nu;

    public void fixtures() {
        wire.cls(NoHeaderorFooterDefinition.class).to(FixedRecordDefinition.class);
        subject = nu.nu(FixedWidthRecordStringer.class);
        data = bakery.cake(1, 1, "chocolate");
    }

    public void testNoHeader() {
        String actual = subject.build(configDummy, data);
        assertEquals(EXPECTED, actual);
    }
}

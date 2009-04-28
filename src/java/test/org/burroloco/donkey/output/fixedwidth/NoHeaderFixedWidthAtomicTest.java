package org.burroloco.donkey.output.fixedwidth;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Bakery;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class NoHeaderFixedWidthAtomicTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private static final String EXPECTED = "1                        chocolate                flour                    egg";
    private FixedWidthRecordStringer subject;
    private Cake cake;
    Config configDummy;
    Bakery bakery;
    Nu nu;

    public void fixtures() {
        wire.cls(NoHeaderDefinition.class).to(FixedRecordDefinition.class);
        subject = nu.nu(FixedWidthRecordStringer.class);
        cake = bakery.cake(1, 1, "chocolate");
    }

    public void testNoHeader() {
        String actual = subject.build(configDummy, cake);
        assertEquals(EXPECTED, actual);
    }
}

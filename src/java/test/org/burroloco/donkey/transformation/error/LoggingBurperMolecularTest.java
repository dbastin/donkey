package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.log.LogCleaner;
import org.burroloco.test.butcher.fixture.checker.file.FileChecker;
import static org.burroloco.test.butcher.fixture.checker.type.Occurrence.ONCE;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.util.wire.Dna;

import java.io.File;

public class LoggingBurperMolecularTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private static final File REPORT = new File("gen/demo/log/transform-errors.log");
    private Burper subject;
    FileChecker fileChecker;
    LogCleaner logCleaner;
    Slice slice;
    Dna dna;
    Nu nu;

    public void fixtures() {
        logCleaner.clean(REPORT);
        dna.strand(Burper.class, LoggingBurper.class, SwallowingBurper.class);
        subject = nu.nu(Burper.class);
    }

    public void testErrorLogging() {
        RuntimeException e = new RuntimeException("random: " + slice);
        subject.error(slice, e);
        fileChecker.check(REPORT, ONCE, "random: \\{\\}");
    }
}

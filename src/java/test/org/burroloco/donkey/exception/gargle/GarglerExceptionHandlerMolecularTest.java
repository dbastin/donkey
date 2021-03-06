package org.burroloco.donkey.exception.gargle;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.butcher.fixture.checker.file.FileChecker;
import org.burroloco.butcher.util.file.FileCleaner;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.util.wire.Dna;

import java.io.File;

import static org.burroloco.butcher.fixture.checker.type.Occurrence.ONCE;

public class GarglerExceptionHandlerMolecularTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private static final File REPORT = new File("gen/demo/log/transform-errors.log");
    private GarglerExceptionHandler subject;

    FileChecker fileChecker;
    FileCleaner fileCleaner;
    Tuple tuple;
    Dna dna;
    Nu nu;

    public void fixtures() {
        fileCleaner.clean(REPORT);
        dna.strand(GarglerExceptionHandler.class, LoggingGarglerExceptionHandler.class);
        subject = nu.nu(GarglerExceptionHandler.class);
    }

    public void testErrorLogging() {
        RuntimeException e = new RuntimeException("random: " + tuple);
        subject.handle(tuple, e);
        fileChecker.check(REPORT, ONCE, "(?ms)random: .*\\{\\}");
    }
}

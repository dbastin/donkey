package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.log.LogCleaner;
import org.burroloco.test.butcher.fixture.checker.file.FileChecker;
import static org.burroloco.test.butcher.fixture.checker.type.Occurrence.ONCE;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

import java.io.File;

public class ErrorReportPukerAtomicTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private static final File REPORT = new File("gen/demo/log/error-report.log");
    private Puker subject;
    FileChecker fileChecker;
    LogCleaner logCleaner;
    Slice slice;
    Impl impl;
    Nu nu;

    public void fixtures() {
        logCleaner.clean(REPORT);
        subject = impl.impl(ErrorReportPuker.class, REPORT);
    }

    public void testErrorReportPuker() {
        TransformException e = new TransformException(slice, "random");
        subject.puke(slice, e);
        fileChecker.check(REPORT, ONCE, "random: \\{\\} for slice: \\{\\}");
    }
}

package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.config.ErrorReport;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.log.LogCleaner;
import org.burroloco.test.butcher.fixture.checker.file.FileChecker;
import static org.burroloco.test.butcher.fixture.checker.type.Occurence.ONCE;
import org.burroloco.test.glue.testcase.TsrTestCase;
import org.burroloco.test.util.io.FileWirer;

import java.io.File;

public class ErrorReportPukerAtomicTest extends TsrTestCase implements LazyFields, HasFixtures {
    private static final String ERROR_FILE_NAME = "log/error-report.log";
    private Puker subject;
    private File errorReport;
    FileChecker fileChecker;
    LogCleaner logCleaner;
    FileWirer file;
    Slice slice;
    Impl impl;
    Nu nu;

    public void fixtures() {
        logCleaner.clean(ERROR_FILE_NAME);
        errorReport = file.file(ERROR_FILE_NAME);
        wire.nu(ErrorReport.class, errorReport).to(ErrorReport.class);
        subject = impl.impl(ErrorReportPuker.class);
    }

    public void testErrorReportPuker() {
        TransformException e = new TransformException(slice, "random");
        subject.puke(slice, e);
        fileChecker.check(errorReport, ONCE, "random: \\{\\} for slice: \\{\\}");
    }

}

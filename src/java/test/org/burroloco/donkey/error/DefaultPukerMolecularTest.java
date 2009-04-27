package org.burroloco.donkey.error;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PukingJob;
import org.burroloco.donkey.log.LogCleaner;
import org.burroloco.test.butcher.fixture.checker.file.FileChecker;
import static org.burroloco.test.butcher.fixture.checker.type.Occurrence.ONCE;
import org.burroloco.test.constants.TestConstants;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.util.wire.Dna;

public class DefaultPukerMolecularTest extends DonkeyTestCase implements HasFixtures, TestConstants, LazyFields {
    private static final String MSG = "Something terrible happened to the job.";
    private Job job;
    FileChecker fileChecker;
    LogCleaner logCleaner;
    Config configDummy;
    Dna dna;
    Nu nu;

    public void fixtures() {
        logCleaner.clean(LOG);
        dna.strand(Job.class, PukingJob.class, BarfingJob.class);
        job = nu.nu(Job.class);
    }

    public void testDefaultPuker() {
        try {
            job.go(configDummy);
            fail("Expected the job to fail");
        } catch (RuntimeException e) {
            checkErrorOriginal(e);
            checkErrorLogging();
        }
    }

    private void checkErrorOriginal(RuntimeException e) {
        String actual = e.getMessage();
        assertEquals(MSG, actual);
    }

    private void checkErrorLogging() {
        fileChecker.check(LOG, ONCE, MSG);
    }
}

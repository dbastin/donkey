package org.burroloco.donkey.exception.job;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.butcher.fixture.checker.file.FileChecker;
import org.burroloco.butcher.util.file.FileCleaner;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.glue.constants.DonkeyTestConstants;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.util.wire.Dna;

import static org.burroloco.butcher.fixture.checker.type.Occurrence.ONCE;

public class ExceptionHandlerMolecularTest extends DonkeyTestCase implements HasFixtures, DonkeyTestConstants, LazyFields {
    private static final String JOB_MSG = "Something terrible happened to the job.";

    FileChecker fileChecker;
    FileCleaner fileCleaner;
    Config configDummy;
    Dna dna;
    Nu nu;

    public void fixtures() {
        fileCleaner.clean(LOG);
        dna.strand(Job.class, ExceptionWrapper.class, BarfingJob.class);
    }

    public void testDefaultBehaviour() {
        Job job = nu.nu(Job.class);
        try {
            job.go(configDummy);
            fail("Expected the job to fail");
        } catch (RuntimeException e) {
            checkDefaultBehaviour(e);
        }
    }

    private void checkDefaultBehaviour(RuntimeException e) {
        assertEquals(JOB_MSG, e.getMessage());
        fileChecker.check(LOG, ONCE, JOB_MSG);
    }
}

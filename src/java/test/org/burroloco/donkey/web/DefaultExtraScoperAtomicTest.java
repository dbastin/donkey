package org.burroloco.donkey.web;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.checker.file.FileChecker;
import org.burroloco.butcher.util.file.FileCleaner;
import static org.burroloco.donkey.glue.constants.DonkeyTestConstants.LOG;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultExtraScoperAtomicTest extends DonkeyTestCase implements HasFixtures {
    ExtraScoper subject;
    FileChecker checker;
    FileCleaner cleaner;

    public void fixtures() {
        cleaner.clean(LOG);
    }

    public void testExtrasFileDoesNotExist() {
        subject.scope("no.file");
        checker.check(LOG, "No file: no.file containing extra injection scopes was found");
    }
}

package org.burroloco.donkey.web;

import org.burroloco.donkey.scope.excluded.OutOfScope;
import org.burroloco.donkey.scope.included.InScope;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.checker.file.FileChecker;
import org.burroloco.butcher.util.file.FileCleaner;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import static org.burroloco.donkey.glue.constants.DonkeyTestConstants.LOG;

public class DefaultScopeExpanderAtomicTest extends DonkeyTestCase implements HasFixtures {
    ScopeExpander subject;
    FileChecker checker;
    FileCleaner cleaner;

    public void fixtures() {
        cleaner.clean(LOG);
    }

    public void testScope() {
        InScope inScope = spider.resolve(InScope.class);
        assertEquals("inScope", inScope.externalize());
    }

    public void testOutOfScope() {
        try {
            OutOfScope outOfScope = spider.resolve(OutOfScope.class);
            assertEquals("outOfScope", outOfScope.externalize());
        } catch (NullPointerException expected) {}
    }

    public void testMissingScopeFileLog() {
        subject.scope("no.file");
        checker.check(LOG, "No file: no.file containing extra injection scopes was found");
    }
}

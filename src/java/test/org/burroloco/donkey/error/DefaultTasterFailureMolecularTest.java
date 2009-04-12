package org.burroloco.donkey.error;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.core.Taster;
import org.burroloco.donkey.error.core.HandledException;
import org.burroloco.donkey.error.listener.assistant.ErrorAssistant;
import org.burroloco.donkey.error.listener.assistant.ErrorAssistants;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.log.LogCleaner;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.transformation.gargler.Gargler;
import org.burroloco.test.butcher.fixture.checker.file.FileChecker;
import org.burroloco.test.constants.TestConstants;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileWirer;

public class DefaultTasterFailureMolecularTest extends DonkeyTestCase implements LazyFields, HasFixtures, TestConstants {
    private Taster subject;
    private RuntimeException errorsAssistantException;
    private RuntimeException originalException;
    ErrorAssistant naughtyAssistantMock;
    ErrorAssistants assistantsMock;
    ThrowableMaster throwables;
    FileChecker fileChecker;
    LogCleaner logCleaner;
    Slurper slurperMock;
    Gargler garglerMock;
    Spitter spitterMock;
    Config configDummy;
    FileWirer file;
    Nu nu;

    public void fixtures() {
        mocks();
        expectedError();
        logCleaner.clean();
    }

    public void testTasterFailureWithNoAssistant() {
        sampleFailure();
    }

    public void testTasterFailureWithAssistant() {
        assistantsMock();
        sampleFailure();
        checkAssistantExceptionsLogged();
    }

    private void mocks() {
        wire.ref(slurperMock).to(Slurper.class);
        wire.ref(garglerMock).to(Gargler.class);
        wire.ref(spitterMock).to(Spitter.class);
    }

    private void expectedError() {
        errorsAssistantException = new RuntimeException("error in error assistant");
        originalException = new RuntimeException("source exception");
        expect.oneCall(slurperMock, originalException, "slurp", configDummy);
    }

    private void assistantsMock() {
        expect.oneCall(assistantsMock, new ErrorAssistant[]{naughtyAssistantMock}, "get");
        expect.oneCall(naughtyAssistantMock, errorsAssistantException, "help", configDummy);
        wire.ref(assistantsMock).to(ErrorAssistants.class);
    }

    private void sampleFailure() {
        subject = nu.nu(Taster.class);
        try {
            subject.sample(configDummy);
            fail("Go should have failed.");
        } catch (HandledException e) {
            assertEquals(originalException, throwables.rootCause(e));
        }
    }

    private void checkAssistantExceptionsLogged() {
        fileChecker.check(file.file(LOG), errorsAssistantException.getMessage());
    }
}

package org.burroloco.test.butcher.fixture.process;

import org.burroloco.test.glue.testcase.DonkeyTestCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommandRunnerMolecularTest extends DonkeyTestCase {
    private static final int EVERYTHING_COOL_MAN = 0;
    private static final int NOT_GOOD = 1;
    CommandRunner runner;

    public void testOk() throws Exception {
        int returnCode = runner.run("sh", "-c", "exit 0");
        assertEquals(EVERYTHING_COOL_MAN, returnCode);
    }

    public void testFail() throws Exception {
        int returnCode = runner.run("sh", "-c", "exit " + NOT_GOOD);
        assertThat(returnCode, equalTo(NOT_GOOD));
    }
}

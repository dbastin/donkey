package org.burroloco.test.butcher.fixture.process;

import org.burroloco.test.glue.testcase.DonkeyTestCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;

public class CommandRunnerMolecularTest extends DonkeyTestCase implements Constructable {
    private static final int EVERYTHING_COOL_MAN = 0;
    private static final int NOT_GOOD = 1;
    private static final String COMMAND_COOL = "exit 0";
    private static final String COMMAND_BAD = "exit 1";
    private static final String WINDOWS_CMD = "cmd.exe,/C,";
    private static final String UNIX_CMD = "sh,-c,";
    private String[] commandCool;
    private String[] commandBad;
    CommandRunner runner;

    public void testOk() throws Exception {
        int returnCode = runner.run(commandCool);
        assertEquals(EVERYTHING_COOL_MAN, returnCode);
    }

    public void testFail() throws Exception {
        int returnCode = runner.run(commandBad);
        assertThat(returnCode, equalTo(NOT_GOOD));
    }

    public void constructor() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            commandCool = (WINDOWS_CMD + COMMAND_COOL).split(",");
            commandBad = (WINDOWS_CMD + COMMAND_BAD).split(",");
        } else {
            commandCool = (UNIX_CMD + COMMAND_COOL).split(",");
            commandBad = (UNIX_CMD + COMMAND_BAD).split(",");
        }
    }
}

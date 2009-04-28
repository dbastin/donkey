package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import org.burroloco.butcher.fixture.process.CommandRunner;

public class DefaultAntRunner implements AntRunner {
    CommandRunner runner;
    ArrayMaster arrays;

    public void run(String... antParams) {
        int antReturnCode = runner.run(ant(antParams));
        org.junit.Assert.assertEquals("Ant", 0, antReturnCode);
    }

    private String[] ant(String... antParams) {
        return arrays.plus(new String[]{"ant"}, antParams);
    }
}

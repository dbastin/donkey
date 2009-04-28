package org.burroloco.test.glue.suite;

import au.net.netstorm.boost.sniper.suite.core.BoostSuite;
import au.net.netstorm.boost.sniper.suite.core.FileBasedTestSuites;
import au.net.netstorm.boost.sniper.suite.core.TestSuites;
import junit.framework.Test;

public class MolecularTestSuite implements BoostSuite {
    private static final TestSuites MOLECULAR = new FileBasedTestSuites("Molecular", MolecularTestSuite.class);

    public static Test suite() {
        return MOLECULAR.suite();
    }

    public TestSuites suites() {
        return MOLECULAR;
    }
}
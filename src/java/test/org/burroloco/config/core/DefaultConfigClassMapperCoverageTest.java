package org.burroloco.config.core;

import org.burroloco.butcher.glue.testcase.ButcherTestCase;

public class DefaultConfigClassMapperCoverageTest extends ButcherTestCase {
    ConfigClassMapper subject;

    public void test() {
        try {
            subject.map(BadType.class);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}

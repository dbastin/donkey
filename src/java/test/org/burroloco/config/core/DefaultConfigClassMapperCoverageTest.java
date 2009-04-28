package org.burroloco.config.core;

import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class DefaultConfigClassMapperCoverageTest extends DonkeyTestCase {
    ConfigClassMapper subject;

    public void test() {
        try {
            subject.map(BadType.class);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}

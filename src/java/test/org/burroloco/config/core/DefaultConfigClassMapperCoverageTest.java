package org.burroloco.config.core;

import org.burroloco.donkey.config.BadType;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class DefaultConfigClassMapperCoverageTest extends TsrTestCase {
    ConfigClassMapper subject;

    public void test() {
        try {
            subject.map(BadType.class);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}

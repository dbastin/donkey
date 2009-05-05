package org.burroloco.donkey.web;

import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultExtraScoperAtomicTest extends DonkeyTestCase {
    ExtraScoper subject;

    public void testExtrasFileDoesNotExist() {
        subject.scope("no.file");
    }
}

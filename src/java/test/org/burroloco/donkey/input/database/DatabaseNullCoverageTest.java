package org.burroloco.donkey.input.database;

import org.burroloco.test.glue.testcase.TsrTestCase;

public class DatabaseNullCoverageTest extends TsrTestCase {
    private DatabaseNull subject = new DatabaseNull();
    
    public void testHasCannedHash() {
        assertEquals(42,subject.hashCode());
    }
}

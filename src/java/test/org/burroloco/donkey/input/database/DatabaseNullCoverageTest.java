package org.burroloco.donkey.input.database;

import org.burroloco.donkey.test.glue.testcase.DonkeyTestCase;

public class DatabaseNullCoverageTest extends DonkeyTestCase {
    private DatabaseNull subject = new DatabaseNull();
    
    public void testHasCannedHash() {
        assertEquals(42,subject.hashCode());
    }
}

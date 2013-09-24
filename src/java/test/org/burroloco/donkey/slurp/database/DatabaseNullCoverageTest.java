package org.burroloco.donkey.slurp.database;

import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DatabaseNullCoverageTest extends DonkeyTestCase {
    private DatabaseNull subject = new DatabaseNull();
    
    public void testHasCannedHash() {
        assertEquals(42,subject.hashCode());
    }
}

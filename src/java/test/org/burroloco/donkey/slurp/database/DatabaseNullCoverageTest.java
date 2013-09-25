package org.burroloco.donkey.slurp.database;

import org.burroloco.donkey.data.core.Null;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import static org.burroloco.donkey.data.core.Null.NULL;

public class DatabaseNullCoverageTest extends DonkeyTestCase {
    private Null subject = NULL;
    
    public void testHasCannedHash() {
        assertEquals(42,subject.hashCode());
    }
}

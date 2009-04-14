package org.burroloco.test.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

// FIX TSR-DONKEY Use or lose.
public interface Database {
    IDatabaseConnection kplusLocal();

    IDatabaseConnection kplusTP();

    IDatabaseConnection kustom();

    IDatabaseConnection opics();

    IDatabaseConnection hsqldb();
}

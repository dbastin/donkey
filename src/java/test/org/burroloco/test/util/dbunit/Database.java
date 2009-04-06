package org.burroloco.test.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

public interface Database {
    IDatabaseConnection kplusLocal();

    IDatabaseConnection kplusTP();

    IDatabaseConnection kustom();

    IDatabaseConnection opics();
}

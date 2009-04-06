package org.burroloco.test.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.IDataSet;

public interface PrimaryKeyColumnFilter {
    void set(IDatabaseConnection connection, IDataSet columnName);
}

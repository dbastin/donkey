package org.burroloco.butcher.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.IDataSet;

public interface DatabaseOperator {
    void insert(IDatabaseConnection conn, IDataSet data);

    void update(IDatabaseConnection conn, IDataSet data);

    void delete(IDatabaseConnection conn, IDataSet data);
}

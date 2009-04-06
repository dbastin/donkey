package org.burroloco.test.util.dbunit;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.IDataSet;
import edge.org.dbunit.operation.DatabaseOperation;
import edge.org.dbunit.operation.DeleteOperation;
import edge.org.dbunit.operation.InsertOperation;
import edge.org.dbunit.operation.UpdateOperation;

public class DefaultDatabaseOperator implements DatabaseOperator {
    PrimaryKeyColumnFilter primaryKey;
    Nu nu;

    public void insert(IDatabaseConnection conn, IDataSet data) {
        execute(conn, data, InsertOperation.class);
    }

    public void update(IDatabaseConnection conn, IDataSet data) {
        execute(conn, data, UpdateOperation.class);
    }

    public void delete(IDatabaseConnection conn, IDataSet data) {
        primaryKey.set(conn, data);
        execute(conn, data, DeleteOperation.class);
    }

    private void execute(IDatabaseConnection conn, IDataSet data, Class<? extends DatabaseOperation> iface) {
        DatabaseOperation operation = nu.nu(iface);
        operation.execute(conn, data);
    }
}

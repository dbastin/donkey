package org.burroloco.test.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.ITable;

public class DefaultColumns implements Columns {
    Database database;

    public boolean has(String tablename, String columnname) {
        try {
            IDatabaseConnection kplus = database.kplusLocal();
            ITable iTable = kplus.createQueryTable(tablename, query(tablename, columnname));
            return iTable.getRowCount() > 0;
        } catch (Exception e) {
            throw new IllegalArgumentException("Problem interrogating table '" + tablename + "'. Check table name.", e);
        }
    }

    private String query(String tablename, String columnname) {
        return "SELECT c.name FROM syscolumns c, sysobjects o where c.id = o.id and o.name = '" +
                tablename + "' and c.name = '" + columnname + "' ";
    }

}

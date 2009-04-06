package org.burroloco.test.util.enrich;

import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.ITable;
import org.burroloco.test.glue.env.LocalParameters;
import org.burroloco.test.util.dbunit.Columns;
import org.burroloco.test.util.dbunit.Database;

public class DefaultEnrichCheckerEngine implements EnrichCheckerEngine {
    LocalParameters local;
    Database database;
    Columns columns;

    public boolean exists(String tablename, String identifier) {
        if (columns.has(tablename, tablename + "_ShortName")) return named(tablename, identifier);
        if (columns.has(tablename, "Comments")) return commented(tablename, identifier);
        if (columns.has(tablename, "Maturity")) return maturity(tablename, identifier);
        throw new IllegalArgumentException(
              "Data dodginess has ensued [" + tablename + "/" + identifier + "]. Check your directory and file names.");
    }

    private boolean named(String tablename, String identifier) {
        return check(tablename, tablename + "_ShortName", identifier + local.mnemonic());
    }

    private boolean commented(String tablename, String identifier) {
        return check(tablename, "Comments", identifier + local.mnemonic());
    }

    private boolean maturity(String tablename, String identifier) {
        return check(tablename, "Maturity", identifier);
    }

    private boolean check(String tablename, String column, String value) {
        String sql = query(tablename, value, column);
        IDatabaseConnection conn = database.kplusLocal();
        ITable table = conn.createQueryTable(tablename, sql);
        return table.getRowCount() != 0;
    }

    private String query(String table, String identifier, String key) {
        return "select " + key + " as ID from " + table + " where " + key + " = '" + identifier + "'";
    }

}

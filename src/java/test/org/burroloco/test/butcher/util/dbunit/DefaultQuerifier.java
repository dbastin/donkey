package org.burroloco.test.butcher.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.ITable;

public class DefaultQuerifier implements Querifier {
    public String getSingleValue(String query, IDatabaseConnection connection, String columnName) {
        ITable table = connection.createQueryTable("blah", query);
        if (table.getRowCount() == 0) throw new NoResultsException(query);
        Object value = table.getValue(0, columnName);
        return value.toString();
    }
}

package org.burroloco.butcher.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

public interface Querifier {
    String getSingleValue(String query, IDatabaseConnection connection, String columnName);
}

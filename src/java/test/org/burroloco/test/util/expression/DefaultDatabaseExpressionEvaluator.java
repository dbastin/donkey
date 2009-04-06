package org.burroloco.test.util.expression;

import edge.org.dbunit.database.IDatabaseConnection;
import org.burroloco.test.util.dbunit.Database;
import org.burroloco.test.util.dbunit.Querifier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultDatabaseExpressionEvaluator implements DatabaseExpressionEvaluator {
    private static final Pattern PATTERN = Pattern.compile("(\\w+)\\.\\.(\\w+)/(.+)");
    Querifier querifier;
    Database database;

    public String eval(String expression) {
        Matcher m = PATTERN.matcher(expression);
        if (m.matches()) return retrieveId(m.group(1), m.group(2), m.group(3));
        throw new InvalidExpressionException(expression);
    }

    private String retrieveId(String database, String tablename, String shortName) {
        String idColumn = tablename + "_Id";
        String snColumn = tablename + "_ShortName";
        String query = "select " + idColumn + " from " + tablename + " where " + snColumn + " = '" + shortName + "'";
        return querifier.getSingleValue(query, connection(database), idColumn);
    }

    private IDatabaseConnection connection(String dbname) {
        if ("KplusLocal".equals(dbname)) return database.kplusLocal();
        else if ("KplusTP".equals(dbname)) return database.kplusTP();
        throw new UnsupportedDatabaseException(dbname);
    }
}

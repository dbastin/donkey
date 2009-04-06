package org.burroloco.test.util.expression;

public class UnsupportedDatabaseException extends RuntimeException {
    public UnsupportedDatabaseException(String dbname) {
        super("Database not supported: " + dbname);
    }
}

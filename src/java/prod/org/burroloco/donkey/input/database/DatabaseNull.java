package org.burroloco.donkey.input.database;

public class DatabaseNull {
    public static final DatabaseNull DB_NULL = new DatabaseNull();
    
    public String toString() {
        return "null";
    }

    public boolean equals(Object obj) {
        return obj instanceof DatabaseNull;
    }

    public int hashCode() {
        return 42;
    }
}

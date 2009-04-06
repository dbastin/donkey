package org.burroloco.donkey.data.error;

import java.util.Set;

public class ColumnMismatchException extends RuntimeException {
    public ColumnMismatchException(Set<String> cols, Set<String> newCols) {
        super("Expected " + cols + " but was " + newCols);
    }
}

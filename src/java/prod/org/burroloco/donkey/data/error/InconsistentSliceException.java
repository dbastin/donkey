package org.burroloco.donkey.data.error;

import org.burroloco.donkey.data.cake.Slice;


public class InconsistentSliceException extends RuntimeException {
    public InconsistentSliceException(int expectedNumFields, Slice slice) {
        super("Expected slice with " + expectedNumFields + " columns but got " + slice.names().size() +
                " column(s) like this: " + slice);
    }
}
 
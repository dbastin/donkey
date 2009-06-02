package org.burroloco.donkey.output.csv;

import java.util.Collection;

public interface SliceProcessor {
    void values(StringBuilder results, Collection values);
}


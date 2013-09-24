package org.burroloco.donkey.spit.csv;

import java.util.Collection;

public interface SliceProcessor {
    void values(StringBuilder results, Collection values);
}


package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public interface Puker {
    void puke(Slice slice, RuntimeException e);
}

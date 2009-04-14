package org.burroloco.donkey.data.check;

import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.data.error.InconsistentSliceException;

// FIX TSR-DONKEY Use or Lose
public class DefaultSliceChecker implements SliceChecker {
    public void check(Slice slice, int expected) {
        if (slice.names().size() != expected) throw new InconsistentSliceException(expected, slice);
    }

}

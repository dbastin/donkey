package org.burroloco.donkey.transformation.transform;

import org.burroloco.donkey.data.cake.Slice;

public interface SliceValueReplacer {
    String replace(String str, Slice slice, String key);
}

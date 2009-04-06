package org.burroloco.donkey.transformation.transform;

import org.burroloco.donkey.data.cake.Slice;

public interface FieldConverter {
    Slice nullTo(Slice in, Object replacement);

    Slice emptyTo(Slice in, Object replacement);
}

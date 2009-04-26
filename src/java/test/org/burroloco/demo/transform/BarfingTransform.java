package org.burroloco.demo.transform;

import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.data.error.InconsistentSliceException;

public class BarfingTransform implements Transform {
    public Slice transform(Slice in) {
        throw new InconsistentSliceException(42, in);
    }
}

package org.burroloco.donkey.transformation.transform;

import org.burroloco.donkey.data.cake.Slice;

public class NoOpTransform implements Transform {

    public Slice transform(Slice in) {
        return in;
    }
}

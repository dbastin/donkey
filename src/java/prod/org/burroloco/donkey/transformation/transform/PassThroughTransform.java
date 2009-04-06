package org.burroloco.donkey.transformation.transform;

import org.burroloco.donkey.data.cake.Slice;

public class PassThroughTransform implements Transform {

    public Slice transform(Slice in) {
        return in;
    }
}

package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;

public class CompositeTransform implements Transform {
    private final Transforms transforms;
    Nu nu;

    public CompositeTransform(Transforms transforms) {
        this.transforms = transforms;
    }

    public Slice transform(Slice in) {
        Slice newSlice = nu.nu(Slice.class);
        for (Transform transform : transforms.get()) {
            newSlice.addAll(transform.transform(in));
        }
        return newSlice;
    }
}

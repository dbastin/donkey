package org.burroloco.donkey.transformation.gargler;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.transformation.error.Puker;
import org.burroloco.donkey.transformation.error.TransformException;
import org.burroloco.donkey.transformation.transform.Transform;

public class DefaultGargler implements Gargler {
    Transform transform;
    Puker puker;
    Nu nu;

    public Cake slosh(Config config, Cake in) {
        Cake out = nu.nu(Cake.class);
        for (Slice slice : in.slices()) tryTransform(out, slice);
        return out;
    }

    private void tryTransform(Cake out, Slice slice) {
        try {
            out.add(transform.transform(slice));
        } catch (TransformException e) {
            // FIX TSR-DONKEY Coverage required...
            // FIX TSR-4241 This could use the ErrorEventListener things...
            puker.puke(slice, e);
        }
    }
}

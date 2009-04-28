package org.burroloco.donkey.transformation.gargler;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.error.transform.Burper;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.transformation.transform.Transform;

import java.util.List;

public class DefaultGargler implements Gargler {
    Transform transform;
    Spitter spitter;
    Burper burper;
    Nu nu;

    public void slosh(Config config, Cake in) {
        Cake out = nu.nu(Cake.class);
        List<Slice> slices = in.slices();
        for (Slice slice : slices) transform(out, slice);
        spitter.pertuh(config, out);
    }

    private void transform(Cake out, Slice slice) {
        try {
            Slice transformed = transform.transform(slice);
            out.add(transformed);
        } catch (RuntimeException e) {
            burper.error(slice, e);
        }
    }
}

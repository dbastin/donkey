package org.burroloco.test.glue.layer;

import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import org.burroloco.config.core.Config;
import org.burroloco.config.override.core.Overrides;

public class OverrideConfigLayer implements Layer {
    private Object ref;
    Overrides overrides;

    public OverrideConfigLayer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        Config config = (Config) method.invoke(ref, args);
        return overrides.apply(config);
    }
}
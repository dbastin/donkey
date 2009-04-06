package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;

public class LoaderLogger implements Layer {
    private final Object ref;
    Log log;

    public LoaderLogger(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        String[] props = (String[]) args[0];
        for (String prop : props) {
            log.info("Loading: " + prop);
        }
        return method.invoke(ref, args);
    }
}

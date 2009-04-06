package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;

public class FileMovingLogger implements Layer {
    private final Object ref;
    Log log;

    public FileMovingLogger(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        String source = (String) args[0];
        String targetDir = (String) args[1];
        log.info("Moving " + source + " to " + targetDir);
        return method.invoke(ref, args);
    }
}

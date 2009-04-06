package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;

import java.io.File;

public class FileScribblerLogger implements Layer {
    private final Object ref;
    Log log;

    public FileScribblerLogger(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        File file = (File) args[0];
        log.info("Writing output to " + file);
        return method.invoke(ref, args);
    }
}

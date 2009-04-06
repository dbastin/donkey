package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import org.burroloco.donkey.config.InputFileName;

public class FileReaderLogger implements Layer {
    private final Object ref;
    Weaken weaken;
    Log log;


    public FileReaderLogger(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        InputFileName input = (InputFileName) args[0];
        log.info("Reading data from " + weaken.w(input));
        return method.invoke(ref, args);
    }
}

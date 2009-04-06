package org.burroloco.interfaces.common.interfacer;

import au.net.netstorm.boost.bullet.farmer.OperationManager;
import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;

public class PausedTestResumer implements Layer {
    private Object ref;
    OperationManager sharedManager;

    public PausedTestResumer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        Object result;
        try {
            result = method.invoke(ref, args);
        } finally {
            sharedManager.done();
        }
        return result;
    }
}

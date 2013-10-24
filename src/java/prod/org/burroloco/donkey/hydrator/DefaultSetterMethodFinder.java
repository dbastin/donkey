package org.burroloco.donkey.hydrator;

import java.lang.reflect.Method;

import static org.apache.commons.beanutils.MethodUtils.getMatchingAccessibleMethod;
import static org.apache.commons.lang.WordUtils.capitalizeFully;

public class DefaultSetterMethodFinder implements SetterMethodFinder {

    public <T> Method find(Class<T> cls, String suffix, Class type) {
        String name = "set" + capitalizeFully(suffix);
        Class[] types = {type};
        Method m = getMatchingAccessibleMethod(cls, name, types);
        if (m == null){
            throw new RuntimeException("There is no method [" + name + "] in [" + cls.getName() + "]");
        }
        return m;
    }
}

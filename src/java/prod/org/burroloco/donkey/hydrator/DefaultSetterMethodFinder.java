package org.burroloco.donkey.hydrator;

import org.burroloco.donkey.mapper.SetterNameMapper;

import java.lang.reflect.Method;

import static org.apache.commons.beanutils.MethodUtils.getMatchingAccessibleMethod;

public class DefaultSetterMethodFinder implements SetterMethodFinder {

    SetterNameMapper setters;

    public <T> Method find(Class<T> cls, String name, Class type) {
        String setter = setters.map(name);
        Class[] types = {type};
        Method m = getMatchingAccessibleMethod(cls, setter, types);
        if (m == null) pop(cls, setter);
        return m;
    }

    private void pop(Class cls, String setter) {
        String msg = "There is no method [" + setter + "] in [" + cls.getName() + "]";
        throw new RuntimeException(msg);
    }
}

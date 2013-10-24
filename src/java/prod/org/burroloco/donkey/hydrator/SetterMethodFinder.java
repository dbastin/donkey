package org.burroloco.donkey.hydrator;

import java.lang.reflect.Method;

public interface SetterMethodFinder {
    <T> Method find(Class<T> cls, String suffix, Class type);
}

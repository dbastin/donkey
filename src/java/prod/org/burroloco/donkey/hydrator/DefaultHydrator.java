package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.gunge.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.sledge.java.lang.reflect.EdgeMethod;
import org.burroloco.donkey.data.core.Tuple;

import java.lang.reflect.Method;
import java.util.Set;

import static org.burroloco.donkey.data.core.Null.NULL;

public class DefaultHydrator implements Hydrator {

    SetterMethodFinder setters;
    EdgeMethod methods;
    EdgeClass classes;

    public <T> T hydrate(Tuple tuple, Class<T> cls) {
        T result = classes.newInstance(cls);
        Set<String> names = tuple.names();
        setAttributes(result, tuple, cls, names);
        return result;
    }

    private <T> void setAttributes(T ref, Tuple tuple, Class<T> cls, Set<String> names) {
        for (String name : names) {
            Object value = tuple.value(name);
            if (value == NULL) continue;
            setAttribute(ref, cls, name, value);
        }
    }

    private <T> void setAttribute(T ref, Class<T> cls, String name, Object value) {
        Class type = value.getClass();
        Method setter = setters.find(cls, name, type);
        methods.invoke(setter, ref, value);
    }
}

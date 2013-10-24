package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.gunge.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.sledge.java.lang.reflect.EdgeMethod;
import org.burroloco.donkey.data.core.Tuple;

import java.lang.reflect.Method;
import java.util.Set;

import static org.burroloco.donkey.data.core.Null.NULL;

public class DefaultHydrator implements Hydrator {

    SetterMethodFinder setters;
    EdgeMethod methoder;
    EdgeClass classer;

    public <T> T hydrate(Tuple tuple, Class<T> cls) {
        T result = classer.newInstance(cls);
        Set<String> attributes = tuple.names();
        setAttributes(result, tuple, cls, attributes);
        return result;
    }

    private <T> void setAttributes(T ref, Tuple tuple, Class<T> cls, Set<String> attributes) {
        for (String attribute : attributes) {
            Object value = tuple.value(attribute);
            if (value == NULL) continue;
            Class type = value.getClass();
            Method setter = setters.find(cls, attribute, type);
            methoder.invoke(setter, ref, value);
        }
    }
}

package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.gunge.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.sledge.java.lang.reflect.EdgeMethod;
import org.burroloco.donkey.data.core.Tuple;

import java.lang.reflect.Method;
import java.util.Set;

import static org.apache.commons.lang.WordUtils.capitalize;

public class DefaultHydrator implements Hydrator {

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
            Method method = setterMethod(cls, attribute);
            Object value = tuple.value(attribute);
            methoder.invoke(method, ref, value);
        }
    }

    private <T> Method setterMethod(Class<T> cls, String suffix) {
        String name = "set" + capitalize(suffix);
        return classer.getMethod(cls, name, String.class);
    }
}

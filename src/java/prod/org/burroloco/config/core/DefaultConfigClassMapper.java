package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.reflect.field.StaticFields;

public class DefaultConfigClassMapper implements ConfigClassMapper {
    StaticFields fielder;
    
    public String map(Class type) {
        if (!fielder.has(type, "NAME")) pop(type);
        return fielder.get(type, "NAME", String.class);
    }

    private void pop(Class type) {
        throw new IllegalArgumentException("Config type '" + type.getSimpleName() + "' requires 'NAME' constant.");
    }
}

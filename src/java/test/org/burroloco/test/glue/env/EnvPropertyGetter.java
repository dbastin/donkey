package org.burroloco.test.glue.env;

import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface EnvPropertyGetter {
    String get(StrictMap<String, String> localProps, String propName);
}

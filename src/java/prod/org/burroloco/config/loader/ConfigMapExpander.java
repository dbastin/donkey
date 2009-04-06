package org.burroloco.config.loader;

import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface ConfigMapExpander {
    StrictMap<String, String> expand(StrictMap<String, String> filename);
}

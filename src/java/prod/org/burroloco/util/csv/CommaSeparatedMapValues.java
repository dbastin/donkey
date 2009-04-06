package org.burroloco.util.csv;

import au.net.netstorm.boost.gunge.collection.StrictMap;

import java.util.List;

public interface CommaSeparatedMapValues {
    List<String> list(StrictMap<String, String> map, String[] keys);
}

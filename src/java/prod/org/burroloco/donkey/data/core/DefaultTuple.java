package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;
import org.burroloco.donkey.data.error.DuplicateColumnException;
import org.burroloco.donkey.data.error.MissingValueException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultTuple extends Primordial implements Tuple {
    private static final NullMaster NULLO = new DefaultNullMaster();
    private Map<String, Object> map = new LinkedHashMap<String, Object>();
    private boolean readOnly;

    public void add(String name, Object value) {
        NULLO.check(name, value);
        safePut(name, value);
    }

    public void addAll(Tuple tuple) {
        safePutAll(tuple);
    }

    public Object value(String name) {
        if (!map.keySet().contains(name)) throw new MissingValueException(name);
        return map.get(name);
    }

    public List<Object> values() {
        return new ArrayList<Object>(map.values());
    }

    public Set<String> names() {
        return map.keySet();
    }

    public void readOnly() {
        readOnly = true;
    }

    private void safePut(String name, Object value) {
        if (readOnly) throw new IllegalArgumentException("Tuple is read only.");
        if (map.containsKey(name)) throw new DuplicateColumnException(name);
        map.put(name, value);
    }

    private void safePutAll(Tuple tuple) {
        for (String key : tuple.names()) safePut(key, tuple.value(key));
    }
}

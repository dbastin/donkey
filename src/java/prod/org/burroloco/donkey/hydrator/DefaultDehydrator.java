package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.beanutils.PropertyUtilsStatic;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.mapper.UpperCarriageCaseMapper;

import java.util.Map;

import static org.burroloco.donkey.data.core.Null.NULL;

public class DefaultDehydrator implements Dehydrator {

    UpperCarriageCaseMapper mapper;
    PropertyUtilsStatic properties;
    Nu nu;

    public Tuple dehydrate(Object o) {
        Tuple result = nu.nu(Tuple.class);
        dehydrate(result, o);
        result.readOnly();
        return result;
    }

    private void dehydrate(Tuple result, Object o) {
        Map<String, Object> props = properties.describe(o);
        for (String key : props.keySet()) {
            if (ignorable(key)) continue;
            String k = mapper.map(key);
            Object v = props.get(key);
            result.add(k, handleNull(v));
        }
    }

    private boolean ignorable(String key) {
        return key.equals("class");
    }

    private Object handleNull(Object value) {
        return value == null ? NULL : value;
    }
}

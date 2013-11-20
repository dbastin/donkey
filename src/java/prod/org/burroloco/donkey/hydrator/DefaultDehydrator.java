package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.beanutils.PropertyUtilsStatic;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.mapper.CarriageCaseMapper;

import java.util.Map;

public class DefaultDehydrator implements Dehydrator {

    PropertyUtilsStatic properties;
    CarriageCaseMapper mapper;
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
            result.add(k, v);
        }
    }

    private boolean ignorable(String key) {
        return key.equals("class");
    }
}

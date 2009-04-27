package org.burroloco.demo.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.transformation.transform.Mapper;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.transformation.transform.FieldConverter;

public class FullNameTransform implements Transform {
    FieldConverter fieldConverter;
    Mapper fullNameMapper;
    Nu nu;

    public Slice transform(Slice in) {
        Slice out = nu.nu(Slice.class);
        out.add("NAME", doNowt("NAME", in));
        out.add("FULL_NAME", fullname("NAME", in));
        out.add("START_DATE", doNowt("START", in));
        return convertFields(out);
    }

    private Slice convertFields(Slice target) {
        return fieldConverter.nullTo(target, "CONVERTED NULL");
    }

    private Object doNowt(String key, Slice in) {
        return in.value(key);
    }

    private String fullname(String key, Slice in) {
        String s = (String) in.value(key);
        return fullNameMapper.map(s);
    }
}
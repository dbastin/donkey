package org.burroloco.demo.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.transformation.transform.Mapper;
import org.burroloco.donkey.transformation.transform.Transform;

public class SuperHeroTransform implements Transform {
    // FIX TSR-DONKEY Drive out FieldConverter usage here
    Mapper marvelMapper;
    Nu nu;

    public Slice transform(Slice in) {
        Slice out = nu.nu(Slice.class);
        out.add("AVERAGE_JOE", doNowt(in));
        out.add("SUPERHERO", shazzzzzam("NAME", in));
        return out;
    }

    private Object doNowt(Slice in) {
        return in.value("NAME");
    }

    private String shazzzzzam(String key, Slice in) {
        String s = (String) in.value(key);
        return marvelMapper.map(s);
    }
}
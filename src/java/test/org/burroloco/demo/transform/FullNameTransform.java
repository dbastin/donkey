package org.burroloco.demo.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.transformation.transform.Mapper;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.transformation.transform.Slices;
import static org.burroloco.donkey.input.database.DatabaseNull.*;

public class FullNameTransform implements Transform {
    Slices slices;
    Mapper fullNameMapper;
    Nu nu;

    public Slice transform(Slice in) {
        Slice out = nu.nu(Slice.class);
        out.add("NAME", in.value("NAME"));
        out.add("FULL_NAME", fullname("NAME", in));
        out.add("START_DATE", in.value("START"));
        return replaceNulls(out);
    }

    private Slice replaceNulls(Slice slice) {
        return slices.replaceAllValues(slice, DB_NULL, "CONVERTED NULL");
    }

    private String fullname(String key, Slice in) {
        String s = (String) in.value(key);
        return fullNameMapper.map(s);
    }
}
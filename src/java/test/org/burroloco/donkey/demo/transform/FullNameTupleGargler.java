package org.burroloco.donkey.demo.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.gargle.Mapper;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.gargle.TupleMaster;

import static org.burroloco.donkey.data.core.Null.NULL;

public class FullNameTupleGargler implements TupleGargler {
    Mapper fullNameMapper;
    TupleMaster master;
    Nu nu;

    public Tuple gargle(Config c, Tuple in) {
        Tuple out = nu.nu(Tuple.class);
        out.add("NAME", in.value("NAME"));
        out.add("FULL_NAME", fullname("NAME", in));
        out.add("START_DATE", in.value("START"));
        return replaceNulls(out);
    }

    private String fullname(String key, Tuple in) {
        String s = (String) in.value(key);
        return fullNameMapper.map(s);
    }

    private Tuple replaceNulls(Tuple tuple) {
        return master.replaceAllValues(tuple, NULL, "CONVERTED NULL");
    }
}
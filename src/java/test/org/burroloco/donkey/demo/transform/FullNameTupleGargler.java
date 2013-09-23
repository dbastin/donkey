package org.burroloco.donkey.demo.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;

import static org.burroloco.donkey.input.database.DatabaseNull.DB_NULL;

import org.burroloco.donkey.transform.Mapper;
import org.burroloco.donkey.transform.TupleGargler;
import org.burroloco.donkey.transform.TupleMaster;

public class FullNameTupleGargler implements TupleGargler {
    Mapper fullNameMapper;
    TupleMaster master;
    Nu nu;

    public Tuple gargle(Tuple in) {
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
        return master.replaceAllValues(tuple, DB_NULL, "CONVERTED NULL");
    }
}
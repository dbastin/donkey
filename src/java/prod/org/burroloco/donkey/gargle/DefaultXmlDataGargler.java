package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DefaultData;
import org.burroloco.donkey.data.core.Tuple;

import java.util.List;

public class DefaultXmlDataGargler implements XmlDataGargler {
    Nu nu;

    public Data gargle(Config config, Data in) {
        Data results = new DefaultData();
        List<Tuple> tuples = in.tuples();
        gargle(results, config, tuples);
        return results;
    }

    private void gargle(Data results, Config config, List<Tuple> tuples) {
        XmlTupleGargler gargler = nu.nu(XmlTupleGargler.class, config);
        for (Tuple in : tuples) {
            Tuple result = gargler.gargle(in);
            results.add(result);
        }
    }
}
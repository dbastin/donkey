package org.burroloco.donkey.gargle;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DefaultData;
import org.burroloco.donkey.data.core.DefaultTuple;
import org.burroloco.donkey.data.core.Tuple;

import java.util.List;

public class DefaultXmlGargler implements XmlGargler{

    public Data gargle(Config config, Data in) {

        Data result = new DefaultData();

        List<Tuple> tuples = in.tuples();
        for (Tuple tuple : tuples) {
            Tuple outputTuple = new DefaultTuple();
            result.add(outputTuple);
        }
        return result;
    }
}

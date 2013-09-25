package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.gunge.sledge.java.lang.EdgeClass;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.ThingyClass;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DefaultData;
import org.burroloco.donkey.data.core.DefaultTuple;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.hydrator.Hydrator;
import org.burroloco.donkey.xml.marshall.XmlMarshaller;

import java.util.List;

public class DefaultXmlGargler implements XmlGargler{

    Hydrator hydrator;
    EdgeClass classer;
    WeakConfig weak;
    XmlMarshaller marshaller;

    public Data gargle(Config config, Data in) {
        Data result = new DefaultData();
        List<Tuple> tuples = in.tuples();
        for (Tuple t : tuples) {
            Tuple out = gargle(t, config);
            result.add(out);
        }
        return result;
    }

    private Tuple gargle(Tuple in, Config config) {
        Object popObject = hydrate(in, config);
        String xmlString = marshaller.marshall(popObject);
        return convert(xmlString);
    }

    private Object hydrate(Tuple in, Config config) {
        Class<Object> thingclass = getThingyClass(config);
        return hydrator.hydrate(in, thingclass);
    }

    private Class<Object> getThingyClass(Config config) {
        String thingyClassString = weak.get(config, ThingyClass.class);
        return classer.forName(thingyClassString);
    }

    private Tuple convert(String xmlString) {
        Tuple outputTuple = new DefaultTuple();
        outputTuple.add("XML", xmlString);
        return outputTuple;
    }
}

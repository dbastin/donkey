package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.gunge.sledge.java.lang.EdgeClass;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HydratorClass;
import org.burroloco.donkey.converter.StringToUnitConverter;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DefaultData;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.hydrator.Hydrator;
import org.burroloco.donkey.xml.marshal.XmlMarshaller;

import java.util.List;

public class DefaultXmlGargler implements XmlGargler{

    StringToUnitConverter converter;
    XmlMarshaller marshaller;
    Hydrator hydrator;
    EdgeClass classer;
    WeakConfig weak;

    public Data gargle(Config config, Data in) {
        Data result = new DefaultData();
        List<Tuple> tuples = in.tuples();
        Class cls = hydratorClass(config);
        for (Tuple t : tuples) result.add(gargle(t, cls));
        return result;
    }

    private Tuple gargle(Tuple in, Class cls) {
        Object ref = hydrator.hydrate(in, cls);
        String xml = marshaller.marshal(ref);
        return converter.convert(xml);
    }

    private Class hydratorClass(Config config) {
        String s = weak.get(config, HydratorClass.class);
        return classer.forName(s);
    }
}
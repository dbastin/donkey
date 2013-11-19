package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import edge.java.lang.ClassStatic;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HydratorClass;
import org.burroloco.donkey.converter.StringToUnitTupleConverter;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.hydrator.Hydrator;
import org.burroloco.donkey.xml.marshal.XmlMarshaller;

public class DefaultXmlTupleGargler implements XmlTupleGargler, Constructable {
    private final Config config;
    private Class cls;

    StringToUnitTupleConverter tuples;
    XmlMarshaller marshaller;
    ClassStatic classer;
    Hydrator hydrator;
    WeakConfig weak;

    public DefaultXmlTupleGargler(Config config) {
        this.config = config;
    }

    public void constructor() {
        cls = hydratorClass(config);
    }

    public Tuple gargle(Tuple in) {
        Object ref = hydrator.hydrate(in, cls);
        String xml = marshaller.marshal(ref);
        return tuples.unit(xml);
    }

    private Class hydratorClass(Config config) {
        String s = weak.get(config, HydratorClass.class);
        return classer.forName(s);
    }
}

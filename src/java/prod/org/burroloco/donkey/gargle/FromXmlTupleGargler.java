package org.burroloco.donkey.gargle;

import edge.java.lang.ClassStatic;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.DehydratorClass;
import org.burroloco.donkey.converter.UnitTupleToStringConverter;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.hydrator.Dehydrator;
import org.burroloco.donkey.xml.unmarshal.XmlUnmarshaller;

public class FromXmlTupleGargler implements TupleGargler {

    UnitTupleToStringConverter tuples;
    XmlUnmarshaller unmarshaller;
    ClassStatic classer;
    Dehydrator dehydrator;
    WeakConfig weak;

    public Tuple gargle(Config config, Tuple in) {
        Class cls = dehydratorClass(config);
        String xml = tuples.convert(in);
        Object o = unmarshaller.unmarshal(cls, xml);
        return dehydrator.dehydrate(o);
    }

    private Class dehydratorClass(Config config) {
        String s = weak.get(config, DehydratorClass.class);
        return classer.forName(s);
    }
}

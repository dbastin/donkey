package org.burroloco.donkey.xml.marshal;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.io.ByteArrayOutputStream;
import edge.javax.xml.bind.JAXBContext;
import edge.javax.xml.bind.JAXBContextStatic;
import edge.javax.xml.bind.Marshaller;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class DefaultXmlMarshaller implements XmlMarshaller {

    private static final String ENCODING = "UTF-8";

    JAXBContextStatic contexts;
    Nu nu;

    public String marshal(Object o) {
        Marshaller m = createMarshaller(o);
        ByteArrayOutputStream s = nu.nu(ByteArrayOutputStream.class);
        m.marshal(o, s);
        return s.toString(ENCODING);
    }

    private JAXBContext createContext(Object o) {
        Class<?> c = o.getClass();
        return contexts.newInstance(c);
    }

    private Marshaller createMarshaller(Object o) {
        JAXBContext ctx = createContext(o);
        Marshaller m = ctx.createMarshaller();
        makePretty(m);
        return m;
    }

    private void makePretty(Marshaller m) {
        m.setProperty(JAXB_FORMATTED_OUTPUT, true);
    }
}

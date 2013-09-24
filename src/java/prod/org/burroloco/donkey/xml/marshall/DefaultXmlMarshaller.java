package org.burroloco.donkey.xml.marshall;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.io.ByteArrayOutputStream;
import edge.javax.xml.bind.JAXBContext;
import edge.javax.xml.bind.JAXBContextStatic;
import edge.javax.xml.bind.Marshaller;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class DefaultXmlMarshaller implements XmlMarshaller {

    JAXBContextStatic jaxbContextStatic;
    Nu nu;

    public String marshall(Object o) {
        JAXBContext jaxbContext = createContext(o);
        Marshaller jaxbMarshaller = createMarshaller(jaxbContext);
        ByteArrayOutputStream stream = nu.nu(ByteArrayOutputStream.class);
        marshall(o, jaxbMarshaller, stream);
        return convertToString(stream);
    }

    private JAXBContext createContext(Object o) {
        Class<?> cls = o.getClass();
        return jaxbContextStatic.newInstance(cls);
    }

    private void marshall(Object o, Marshaller jaxbMarshaller, ByteArrayOutputStream stream) {
        jaxbMarshaller.marshal(o, stream);
    }

    private Marshaller createMarshaller(JAXBContext jaxbContext) {
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        makePretty(jaxbMarshaller);
        return jaxbMarshaller;
    }


    private String convertToString(ByteArrayOutputStream stream) {
        return stream.toString("UTF-8");
    }

    private void makePretty(Marshaller m) {
        m.setProperty(JAXB_FORMATTED_OUTPUT, true);
    }
}

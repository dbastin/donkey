package org.burroloco.donkey.xml.unmarshal;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.io.ByteArrayInputStream;
import edge.java.io.InputStream;
import edge.javax.xml.bind.JAXBContext;
import edge.javax.xml.bind.JAXBContextStatic;
import edge.javax.xml.bind.Unmarshaller;

public class DefaultXmlUnmarshaller implements XmlUnmarshaller {
    JAXBContextStatic context;
    Nu nu;

    public <T> Object unmarshal(Class<T> cls, String xml) {
        InputStream is = nu.nu(ByteArrayInputStream.class, xml.getBytes());
        JAXBContext context = this.context.newInstance(cls);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(is);
    }
}

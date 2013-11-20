package org.burroloco.donkey.xml.unmarshal;

public interface XmlUnmarshaller {
    <T> Object unmarshal(Class<T> cls, String xml);
}

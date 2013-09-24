package edge.javax.xml.bind;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface JAXBContext extends Edge {
    Marshaller createMarshaller();
}

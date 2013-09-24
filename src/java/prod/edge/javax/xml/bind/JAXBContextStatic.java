package edge.javax.xml.bind;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface JAXBContextStatic extends Edge {
    JAXBContext newInstance(Class... classes);
}

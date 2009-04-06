package edge.javax.xml.parsers;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

public interface SAXParser extends Edge {
    // OK IllegalType {
    void parse(File file, DefaultHandler handler);
    // } OK IllegalType 
}

package edge.java.text;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface MessageFormatStatic extends Edge {
    String format(String format,  Object... arguments);
}

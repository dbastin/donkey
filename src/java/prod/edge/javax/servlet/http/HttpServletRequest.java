package edge.javax.servlet.http;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.util.Enumeration;

public interface HttpServletRequest extends Edge {
    Enumeration getAttributeNames();
    Object getAttribute(String s);
}
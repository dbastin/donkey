package edge.java.text;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.util.Date;

public interface DateFormat extends Edge {
    Date parse(String source);

    String format(Date date);
}

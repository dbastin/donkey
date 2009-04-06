package edge.org.apache.commons.lang.time;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.util.Date;

public interface DateFormatUtilsStatic extends Edge {
    String format(Date date, String pattern);
}

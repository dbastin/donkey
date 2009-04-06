package edge.org.apache.commons.lang.time;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.util.Date;

public interface DateUtilsStatic extends Edge {
    Date parseDate(String string, String[] parsePatterns);

    Date addDays(Date date, int amount);
}

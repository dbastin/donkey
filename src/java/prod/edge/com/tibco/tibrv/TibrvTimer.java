package edge.com.tibco.tibrv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;

public interface TibrvTimer extends Edge, Unedgable {
    void resetInterval(double v);

    double getInterval();
}
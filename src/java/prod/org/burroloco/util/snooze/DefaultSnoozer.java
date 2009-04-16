package org.burroloco.util.snooze;

import au.net.netstorm.boost.bullet.edge.java.lang.ThreadStatic;

public class DefaultSnoozer implements Snoozer {
    ThreadStatic threadStatic;
    public void snooze(long periodMillis) {
        // OK GenericIllegalRegexp {
        threadStatic.sleep(periodMillis);
        // } GenericIllegalRegexp
    }
}

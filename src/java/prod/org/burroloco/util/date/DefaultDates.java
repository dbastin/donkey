package org.burroloco.util.date;

import java.util.Date;

public class DefaultDates implements Dates {
    public Date now() {
        // OK IllegalRegexp {
        return new Date();
        // }
    }
}

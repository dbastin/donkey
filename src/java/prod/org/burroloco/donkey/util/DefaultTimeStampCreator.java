package org.burroloco.donkey.util;

import org.burroloco.util.date.Dates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DefaultTimeStampCreator implements TimeStampCreator {
    private static final DateFormat FORMAT = new SimpleDateFormat("yyyyMMddhhmmssSSS");
    Dates dates;

    public synchronized String getTimeStamp() {
        return FORMAT.format(dates.now());
    }
}

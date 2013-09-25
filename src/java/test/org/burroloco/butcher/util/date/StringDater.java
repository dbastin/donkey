package org.burroloco.butcher.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class StringDater {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private StringDater() {
    }

    public static Date date(String s) {
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

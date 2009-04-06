package org.burroloco.util.date;

import java.util.Date;

public interface DateConverter {
    String convert(String date, String fromPattern, String toPattern);

    String convert(Date date, String toPattern);

}

package org.burroloco.util.date;

import edge.org.apache.commons.lang.time.DateFormatUtilsStatic;
import edge.org.apache.commons.lang.time.DateUtilsStatic;

import java.util.Date;

// FIX TSR-DONKEY Use or Lose
public class DefaultDateConverter implements DateConverter {
    DateFormatUtilsStatic formatUtils;
    DateUtilsStatic dateUtils;

    public String convert(String dateString, String fromPattern, String toPattern) {
        Date date = dateUtils.parseDate(dateString, new String[]{fromPattern});
        return convert(date, toPattern);
    }

    public String convert(Date date, String toPattern) {
        return formatUtils.format(date, toPattern);
    }

}

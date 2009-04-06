package org.burroloco.util.date;

import edge.org.apache.commons.lang.time.DateFormatUtilsStatic;
import org.burroloco.donkey.data.cake.Slice;

import java.util.Date;

public class DefaultDateTruncator implements DateTruncator {
    DateFormatUtilsStatic dateUtil;

    public void truncate(Slice noEmpties, Slice dates, String field) {
        Object value = noEmpties.value(field);
        if (value instanceof Date)
            dates.add(field, dateUtil.format((Date) value, "yyyy-MM-dd"));
    }
}

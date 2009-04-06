package org.burroloco.util.date;

import org.burroloco.donkey.data.cake.Slice;

public interface DateTruncator {
    void truncate(Slice noEmpties, Slice dates, String field);
}

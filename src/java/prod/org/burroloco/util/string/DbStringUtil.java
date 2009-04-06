package org.burroloco.util.string;

import org.burroloco.donkey.data.cake.Slice;

public interface DbStringUtil {
    String concatColumns(Slice in, String... columns);
}

package org.burroloco.util.string;

import java.util.List;

public class DefaultStringUnique implements StringUnique, ShortNameUnique, LongNameUnique {
    private final boolean alwaysStamp;
    private final int suffixlength;
    private final int maxlength;
    StringStamper stamper;
    List<String> names;

    public DefaultStringUnique(boolean alwaysStamp, int suffixlength, int maxlength) {
        this.alwaysStamp = alwaysStamp;
        this.suffixlength = suffixlength;
        this.maxlength = maxlength;
    }

    public String unique(String name) {
        String unique = alwaysStamp || names.contains(name) ? uniqize(name, 1) : name;
        names.add(unique);
        return unique;
    }

    private String uniqize(String name, int index) {
        String unique = stamper.stamp(name, suffixlength, maxlength, index);
        if (!names.contains(unique)) return unique;
        return uniqize(name, index + 1);
    }
}

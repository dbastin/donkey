package org.burroloco.util.string;

import edge.org.apache.commons.lang.StringUtilsStatic;

public class DefaultStringStamper implements StringStamper {
    StringUtilsStatic padder;
    StringTruncate truncate;

    public String stamp(String name, int suffixlength, int maxlength, int index) {
        String suffix = padder.leftPad("" + index, suffixlength, '0');
        return format(name, suffixlength, maxlength, suffix);
    }

    private String format(String name, int suffixlength, int maxlength, String suffix) {
        String chopped = truncate.truncate(name, maxlength - suffixlength);
        return chopped + suffix;
    }
}

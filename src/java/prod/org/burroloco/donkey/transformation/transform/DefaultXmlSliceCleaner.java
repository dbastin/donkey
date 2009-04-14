package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.lang.StringEscapeUtilsStatic;
import org.burroloco.donkey.data.cake.Slice;

// FIX TSR-DONKEY Use or Lose
public class DefaultXmlSliceCleaner implements XmlSliceCleaner {
    StringEscapeUtilsStatic escaper;
    Nu nu;

    public Slice clean(Slice in) {
        Slice clean = nu.nu(Slice.class);
        for (String col : in.names()) {
            String value = cleanValue(in.value(col));
            clean.add(col, value);
        }
        return clean;
    }

    private String cleanValue(Object value) {
        return escaper.escapeXml(value.toString());
    }
}

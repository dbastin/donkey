package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.lang.StringEscapeUtilsStatic;
import org.burroloco.donkey.data.cake.Slice;

import java.util.Set;

// FIX TSR-DONKEY Use or Lose
public class XmlEscaper implements Transform {
    StringEscapeUtilsStatic escaper;
    Nu nu;

    public Slice transform(Slice in) {
        Slice result = nu.nu(Slice.class);
        Set<String> names = in.names();
        for (String name : names) escape(in, result, name);
        return result;
    }

    private void escape(Slice in, Slice result, String name) {
        String value = (String) in.value(name);
        String escaped = escaper.escapeXml(value);
        result.add(name, escaped);
    }
}

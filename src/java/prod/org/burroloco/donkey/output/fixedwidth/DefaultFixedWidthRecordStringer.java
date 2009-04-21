package org.burroloco.donkey.output.fixedwidth;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.util.string.Filler;
import org.burroloco.util.string.Tail;

import java.util.Map;

public class DefaultFixedWidthRecordStringer implements FixedWidthRecordStringer {
    FixedRecordDefinition definition;
    Filler filler;
    Tail tail;

    public String build(Config config, Cake cake) {
        String header = definition.header(config);
        if (header.length() > 0) header += LINE; 
        String rows = rows(cake);
        return header + rows;
    }

    private String rows(Cake cake) {
        String result = "";
        for (Slice slice : cake.slices()) result += row(slice) + LINE;
        return tail.strip(result, LINE);
    }

    private String row(Slice slice) {
        String result = "";
        for (String name : slice.names()) result += column(slice, name);
        return result;
    }

    private String column(Slice slice, String name) {
        String s = "" + slice.value(name);
        int width = width(name);
        return filler.fill(s, width);
    }

    private int width(String name) {
        Map<String, Integer> widths = definition.widths();
        return widths.get(name);
    }
}

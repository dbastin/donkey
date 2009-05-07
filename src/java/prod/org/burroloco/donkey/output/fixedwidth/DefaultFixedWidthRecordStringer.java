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
        String header = header(config);
        String rows = rows(cake);
        String footer = footer(config, cake);
        return header + rows + footer;
    }

    private String header(Config config) {
        String header = definition.header(config);
        if (header.length() > 0) header += LINE;
        return header;
    }

    private Integer rowCount (Cake cake) {
        return cake.slices().size();
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

    private String footer(Config config, Cake cake) {
        String footer = definition.footer(config, rowCount(cake));
        if (footer.length() > 0) footer = LINE + footer;
        return footer;
    }
}

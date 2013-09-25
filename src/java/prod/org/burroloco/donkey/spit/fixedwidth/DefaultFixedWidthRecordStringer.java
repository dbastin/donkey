package org.burroloco.donkey.spit.fixedwidth;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.util.string.Filler;
import org.burroloco.util.string.Tail;

import java.util.Map;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;

public class DefaultFixedWidthRecordStringer implements FixedWidthRecordStringer {
    FixedRecordDefinition definition;
    Filler filler;
    Tail tail;

    public String build(Config config, Data data) {
        String header = header(config);
        String rows = rows(data);
        String footer = footer(config, data);
        return header + rows + footer;
    }

    private String header(Config config) {
        String header = definition.header(config);
        if (header.length() > 0) header += LINE;
        return header;
    }

    private Integer rowCount (Data data) {
        return data.tuples().size();
    }

    private String rows(Data data) {
        String result = "";
        for (Tuple tuple : data.tuples()) result += row(tuple) + LINE;
        return tail.strip(result, LINE);
    }

    private String row(Tuple tuple) {
        String result = "";
        for (String name : tuple.names()) result += column(tuple, name);
        return result;
    }

    private String column(Tuple tuple, String name) {
        String s = "" + tuple.value(name);
        int width = width(name);
        return filler.fill(s, width);
    }

    private int width(String name) {
        Map<String, Integer> widths = definition.widths();
        return widths.get(name);
    }

    private String footer(Config config, Data data) {
        String footer = LINE + definition.footer(config, rowCount(data));
        return footer;
    }
}

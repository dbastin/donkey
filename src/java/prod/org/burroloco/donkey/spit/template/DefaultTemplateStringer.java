package org.burroloco.donkey.spit.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;

public class DefaultTemplateStringer implements TemplateStringer {
    TemplateExpander expander;

    public String text(Config config, Data data) {
        StringBuilder result = new StringBuilder();
        for (Tuple tuple : data.tuples()) append(config, result, tuple);
        return result.toString();
    }

    public void append(Config config, StringBuilder result, Tuple tuple) {
        String expanded = expander.expand(config, tuple);
        result.append(expanded).append(LINE);
    }
}

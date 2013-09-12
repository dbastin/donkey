package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Tuple;

public class DefaultSqlTemplateExpander implements SqlTemplateExpander {
    TemplateExpander expander;

    public String expand(Config config, Tuple tuple) {
        String expanded = expander.expand(config, tuple);
        return unquoteNull(expanded);
    }

    private String unquoteNull(String expanded) {
        return expanded.replaceAll("\'null\'", "null");
    }
}

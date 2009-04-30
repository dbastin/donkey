package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultSqlTemplateSliceExpander implements SqlTemplateSliceExpander {
    TemplateSliceExpander expander;

    public String expand(Config config, Slice slice) {
        String expanded = expander.expand(config, slice);
        return unquoteNull(expanded);
    }

    private String unquoteNull(String expanded) {
        return expanded.replaceAll("\'null\'", "null");
    }
}

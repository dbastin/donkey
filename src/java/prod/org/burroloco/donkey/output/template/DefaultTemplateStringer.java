package org.burroloco.donkey.output.template;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultTemplateStringer implements TemplateStringer {
    TemplateSliceExpander expander;

    public String text(Config config, Cake cake) {
        StringBuilder result = new StringBuilder();
        for (Slice slice : cake.slices()) append(config, result, slice);
        return result.toString();
    }

    public void append(Config config, StringBuilder result, Slice slice) {
        String expanded = expander.expand(config, slice);
        result.append(expanded).append(LINE);
    }
}

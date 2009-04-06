package org.burroloco.donkey.output.replacing;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultExpandingStringer implements ExpandingStringer {
    TemplateSliceExpander expander;

    public String text(Config config, Cake cake) {
        StringBuilder result = new StringBuilder();
        for (Slice slice : cake.slices()) append(config, result, slice);
        return result.toString();
    }

    public void append(Config config, StringBuilder result, Slice slice) {
        result.append(expander.expand(config, slice)).append(LINE);
    }
}

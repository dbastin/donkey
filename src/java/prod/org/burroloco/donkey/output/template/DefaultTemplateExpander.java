package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultTemplateExpander implements TemplateExpander {
    TemplateSelector selector;
    Templator templator;

    public String expand(Config config, Slice slice) {
        String template = selector.select(config, slice);
        return templator.apply(slice, template);
    }
}

package org.burroloco.donkey.spit.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultTemplateExpander implements TemplateExpander {
    TemplateSelector selector;
    Templator templator;

    public String expand(Config config, Tuple tuple) {
        String template = selector.select(config, tuple);
        return templator.apply(tuple, template);
    }
}

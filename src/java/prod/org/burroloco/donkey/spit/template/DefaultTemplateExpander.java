package org.burroloco.donkey.spit.template;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.OutputTemplate;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultTemplateExpander implements TemplateExpander {
    Templator templator;
    WeakConfig weak;

    public String expand(Config config, Tuple tuple) {
        String template = weak.get(config, OutputTemplate.class);
        return templator.apply(tuple, template);
    }
}

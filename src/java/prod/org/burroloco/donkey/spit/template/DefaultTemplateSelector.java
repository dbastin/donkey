package org.burroloco.donkey.spit.template;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.OutputTemplate;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultTemplateSelector implements TemplateSelector {
    WeakConfig weak;

    public String select(Config config, Tuple tuple) {
        return weak.get(config, OutputTemplate.class);
    }
}
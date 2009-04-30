package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.OutputTemplate;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultTemplateSelector implements TemplateSelector {
    WeakConfig weak;

    public String select(Config config, Slice slice) {
        return weak.get(config, OutputTemplate.class);
    }
}

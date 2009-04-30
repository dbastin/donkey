package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Slice;

public interface TemplateSelector {
    String select(Config config, Slice slice);
}

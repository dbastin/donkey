package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Tuple;

public interface TemplateExpander {
    String expand(Config config, Tuple tuple);
}

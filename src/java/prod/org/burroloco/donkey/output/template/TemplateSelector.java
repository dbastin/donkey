package org.burroloco.donkey.output.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public interface TemplateSelector {
    String select(Config config, Tuple tuple);
}

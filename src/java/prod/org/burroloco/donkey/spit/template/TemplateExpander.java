package org.burroloco.donkey.spit.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public interface TemplateExpander {
    String expand(Config config, Tuple tuple);
}

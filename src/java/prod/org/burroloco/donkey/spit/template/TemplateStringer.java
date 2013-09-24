package org.burroloco.donkey.spit.template;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public interface TemplateStringer {
    String text(Config config, Data data);
}

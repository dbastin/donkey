package org.burroloco.donkey.output.replacing;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Slice;

public interface TemplateSliceExpander {
    String expand(Config config, Slice slice);
}

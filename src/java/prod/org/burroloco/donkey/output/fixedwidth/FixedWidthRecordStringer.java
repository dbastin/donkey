package org.burroloco.donkey.output.fixedwidth;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;

public interface FixedWidthRecordStringer {
    String build(Config config, Data data);
}

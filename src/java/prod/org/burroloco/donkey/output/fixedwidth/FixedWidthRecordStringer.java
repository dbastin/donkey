package org.burroloco.donkey.output.fixedwidth;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public interface FixedWidthRecordStringer {
    String build(Config config, Cake cake);
}

package org.burroloco.donkey.output.fixedwidth;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

// FIX TSR-DONKEY Use or Lose
public interface FixedWidthRecordStringer {
    String build(Config config, Cake cake);
}

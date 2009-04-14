package org.burroloco.donkey.output.fixedwidth;

import org.burroloco.config.core.Config;

import java.util.Map;

// FIX TSR-DONKEY Use or Lose
public interface FixedRecordDefinition {
    String header(Config config);
    Map<String, Integer> widths();
}

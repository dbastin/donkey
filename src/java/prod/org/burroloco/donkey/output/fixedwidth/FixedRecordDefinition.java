package org.burroloco.donkey.output.fixedwidth;

import org.burroloco.config.core.Config;

import java.util.Map;

public interface FixedRecordDefinition {
    String header(Config config);
    Map<String, Integer> widths();
}

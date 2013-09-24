package org.burroloco.donkey.spit.fixedwidth;

import org.burroloco.config.core.Config;

import java.util.Map;

public interface FixedRecordDefinition {
    String header(Config config);
    Map<String, Integer> widths();
    String footer(Config config, Integer rowcount);
}

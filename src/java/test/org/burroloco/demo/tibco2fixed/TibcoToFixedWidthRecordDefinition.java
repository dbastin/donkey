package org.burroloco.demo.tibco2fixed;

import org.burroloco.donkey.output.fixedwidth.FixedRecordDefinition;
import org.burroloco.config.core.Config;

import java.util.Map;
import java.util.HashMap;

public class TibcoToFixedWidthRecordDefinition implements FixedRecordDefinition
{
    public String header(Config config) {
        return "ID              NAME";
    }

    // FIX DONKEY WIP Please leave...
    public Map<String, Integer> widths() {
        return new HashMap<String, Integer>();
    }
}

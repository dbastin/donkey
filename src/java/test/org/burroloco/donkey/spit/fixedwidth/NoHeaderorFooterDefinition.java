package org.burroloco.donkey.spit.fixedwidth;

import org.burroloco.config.core.Config;

import java.util.HashMap;
import java.util.Map;

public class NoHeaderorFooterDefinition implements FixedRecordDefinition {
    public String header(Config config) {
        return "";
    }

    public Map<String, Integer> widths() {
        Map<String, Integer> w = new HashMap<String, Integer>();
        w.put("key", 25);
        w.put("value", 25);
        w.put("anotherValue", 25);
        w.put("yetAnotherValue", 0);
        return w;
    }

    public String footer(Config config, Integer rowcount) {
        return "";
    }

}

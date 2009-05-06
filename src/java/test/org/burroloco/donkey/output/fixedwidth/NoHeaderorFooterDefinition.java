package org.burroloco.donkey.output.fixedwidth;

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
        w.put("flavour", 25);
        w.put("mainly", 25);
        w.put("some.Ref", 0);
        return w;
    }

    public String footer(Config config) {
        return "";
    }

}

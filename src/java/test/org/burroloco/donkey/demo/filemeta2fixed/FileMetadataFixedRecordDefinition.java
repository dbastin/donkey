package org.burroloco.donkey.demo.filemeta2fixed;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.spit.fixedwidth.FixedRecordDefinition;

import java.util.HashMap;
import java.util.Map;

public class FileMetadataFixedRecordDefinition implements FixedRecordDefinition {

    public String header(Config config) {
        return "FileName                 LineCount                ByteCount";
    }

    public Map<String, Integer> widths() {
        Map<String, Integer> w = new HashMap<String, Integer>();
        w.put("FileName", 25);
        w.put("LineCount", 25);
        w.put("ByteCount", 1);
        return w;
    }
    public String footer(Config config, Integer rowcount) {
        return "Footer";

    }
}

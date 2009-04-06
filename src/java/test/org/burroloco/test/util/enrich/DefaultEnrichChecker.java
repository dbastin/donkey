package org.burroloco.test.util.enrich;

import java.io.File;

public class DefaultEnrichChecker implements EnrichChecker {
    EnrichCheckerEngine engine;
    
    public boolean exists(File file) {
        File parent = file.getParentFile();
        String tablename = parent.getName();
        String identifier = prefix(file);
        return engine.exists(tablename, identifier);
    }

    private String prefix(File file) {
        String name = file.getName();
        int dot = name.indexOf(".");
        return name.substring(0, dot);
    }
}

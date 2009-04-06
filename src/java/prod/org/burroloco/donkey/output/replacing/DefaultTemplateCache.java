package org.burroloco.donkey.output.replacing;

import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DefaultTemplateCache implements TemplateCache {
    private final Map<String, String> cache = new HashMap<String, String>();
    FileUtilsStatic fileUtils;

    public String get(String filename) {
        if (!cache.containsKey(filename)) store(filename);
        return cache.get(filename);
    }

    private void store(String filename) {
        String template = fileUtils.readFileToString(new File(filename));
        cache.put(filename, template);
    }
}

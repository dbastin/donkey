package org.burroloco.test.butcher.util.io;

import java.io.File;
import java.util.Map;

public interface Replace {
    void exec(File source, File dest, Map<String, String> replacements);
}

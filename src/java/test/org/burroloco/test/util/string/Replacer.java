package org.burroloco.test.util.string;

import java.util.Map;

public interface Replacer {
    String replace(String input, Map<String, String> replacements);
}

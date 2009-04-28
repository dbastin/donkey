package org.burroloco.test.butcher.util.string;

import java.util.Map;

public interface Replacer {
    String replace(String input, Map<String, String> replacements);
}

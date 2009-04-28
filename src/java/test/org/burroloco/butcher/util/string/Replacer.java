package org.burroloco.butcher.util.string;

import java.util.Map;

public interface Replacer {
    String replace(String input, Map<String, String> replacements);
}

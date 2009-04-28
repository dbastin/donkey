package org.burroloco.test.butcher.util.string;

import java.util.Map;

public class DefaultReplacer implements Replacer {
    public String replace(String input, Map<String, String> replacements) {
        String output = input;
        for (String was : replacements.keySet()) {
            String now = replacements.get(was);
            output = output.replaceAll(was, now);
        }
        return output;
    }
}

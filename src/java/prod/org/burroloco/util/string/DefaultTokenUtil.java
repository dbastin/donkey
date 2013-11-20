package org.burroloco.util.string;

import java.util.Map;

public class DefaultTokenUtil implements TokenUtil {
    private static final String IGNORE_CASE = "(?i)";

    Tokenizer tokenizer;

    public String replace(String input, Map<String, String> replacements) {
        String output = input;
        for (String was : replacements.keySet()) {
            String now = replacements.get(was);
            String token = IGNORE_CASE + tokenizer.token(was);
            output = output.replaceAll(token, now);
        }
        return output;
    }
}
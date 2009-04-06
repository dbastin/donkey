package org.burroloco.donkey.transformation.transform;

import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.util.string.TokenUtil;

import java.util.HashMap;
import java.util.Map;

public class DefaultSliceValueReplacer implements SliceValueReplacer {
    TokenUtil tokens;

    public String replace(String str, Slice slice, String key) {
        Map<String, String> replacements = replacements(slice, key);
        return tokens.replace(str, replacements);
    }

    private Map<String, String> replacements(Slice slice, String key) {
        Map<String, String> replacements = new HashMap<String, String>();
        replacements.put(key, (String) slice.value(key));
        return replacements;
    }
}

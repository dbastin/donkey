package org.burroloco.test.util.mnemonic;

import org.burroloco.test.glue.env.LocalParameters;
import org.burroloco.util.string.TokenUtil;

import java.util.HashMap;
import java.util.Map;

public class DefaultMnemonicFilter implements MnemonicFilter {
    private static final String ENV = "ENV";
    LocalParameters local;
    TokenUtil tokens;

    public String filter(String in) {
        return tokens.replace(in, replacements());
    }

    private Map<String, String> replacements() {
        Map<String, String> replacements = new HashMap<String, String>();
        replacements.put(ENV, local.mnemonic());
        return replacements;
    }

}

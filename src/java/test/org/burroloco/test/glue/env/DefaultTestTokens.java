package org.burroloco.test.glue.env;

import org.burroloco.tibco.config.TibcoParameters;

import java.util.HashMap;
import java.util.Map;

// FIX TSR-DONKEY Lose or Use in Tibco2FileDemoTest
public class DefaultTestTokens implements TestTokens {
    TibcoParameters tibco;

    public Map<String, String> replacements() {
        Map<String, String> replacements = new HashMap<String, String>();
        tibco(replacements);
        return replacements;
    }

    private void tibco(Map<String, String> replacements) {
        replacements.put("DAEMON", tibco.daemon());
        replacements.put("NETWORK", tibco.network());
        replacements.put("SERVICE", tibco.service());
    }

}

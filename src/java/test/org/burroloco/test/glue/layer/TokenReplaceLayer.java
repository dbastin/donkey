package org.burroloco.test.glue.layer;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import org.burroloco.test.glue.env.TestTokens;
import org.burroloco.util.string.TokenUtil;

import java.util.Map;
import java.util.Set;

public class TokenReplaceLayer implements Layer {
    private Object ref;
    TestTokens tokens;
    TokenUtil util;

    public TokenReplaceLayer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        Object result = method.invoke(ref, args);
        tweak((StrictMap<String, String>) result);
        return result;
    }

    private void tweak(StrictMap<String, String> map) {
        Map<String, String> replacements = tokens.replacements();
        for (String key : keys(map)) {
            String value = map.get(key);
            String nu = util.replace(value, replacements);
            map.remove(key);
            map.put(key, nu);
        }
    }

    private String[] keys(StrictMap<String, String> map) {
        Set<String> set = map.keySet();
        return set.toArray(new String[0]);
    }
}

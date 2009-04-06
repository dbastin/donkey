package org.burroloco.test.util.expression;

import org.burroloco.test.util.string.StringGroupFinder;
import org.burroloco.util.string.TokenUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DefaultDatabaseExpressionResolver implements DatabaseExpressionResolver {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("@(K.*?)@");
    DatabaseExpressionEvaluator evaluator;
    StringGroupFinder finder;
    TokenUtil tokenUtils;

    public String resolve(String original) {
        Map<String, String> reps = new HashMap<String, String>();
        List<String> matches = finder.find(original, TOKEN_PATTERN, 1);
        for (String match : matches) addReplacement(match, reps);
        return tokenUtils.replace(original, reps);
    }

    private void addReplacement(String match, Map<String, String> reps) {
        if (!reps.containsKey(match)) reps.put(match, evaluator.eval(match));
    }
}

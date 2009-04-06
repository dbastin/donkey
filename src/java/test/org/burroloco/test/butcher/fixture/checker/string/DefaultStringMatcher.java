package org.burroloco.test.butcher.fixture.checker.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultStringMatcher implements StringMatcher {
    public int countMatches(String content, String expectation) {
        Matcher matcher = Pattern.compile(expectation).matcher(content);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }
}

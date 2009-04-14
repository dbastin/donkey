package org.burroloco.test.butcher.fixture.checker.string;

import org.burroloco.test.butcher.exception.MissingExpectationException;
import org.burroloco.test.butcher.fixture.checker.type.Occurrence;
import static org.burroloco.test.butcher.fixture.checker.type.Occurrence.MANY;
import static org.burroloco.test.butcher.fixture.checker.type.Occurrence.ONCE;

public class DefaultStringChecker implements StringChecker {
    StringMatcher matcher;

    public void check(String content, String... expectations) {
        check(content, ONCE, expectations);
    }

    public void check(String content, Occurrence type, String... expectations) {
        for (String expectation : expectations) checkMatches(content, type, expectation);
    }

    private void checkMatches(String content, Occurrence type, String expectation) {
        int matches = matcher.countMatches(content, expectation);
        if (type.equals(MANY)) checkAtLeastOne(expectation, matches, content);
        else if (type.equals(ONCE)) checkOnlyOne(expectation, matches, content);
        else checkMissing(expectation, matches, content);
    }

    private void checkAtLeastOne(String expectation, int matches, String content) {
        if (matches == 0)
            pop("Found no occurrences of \"" + expectation + "\", expected at least 1 in:\n " + content);
    }

    private void checkOnlyOne(String expectation, int matches, String content) {
        if (matches != 1)
            pop("Found " + matches + " occurrences of \"" + expectation + "\", expected 1 in:\n " + content);
    }

    private void checkMissing(String expectation, int matches, String content) {
        if (matches != 0)
            pop("Found " + matches + " occurrences of \"" + expectation + "\", expected 0 in:\n " + content);
    }

    private void pop(String msg) {
        throw new MissingExpectationException(msg);
    }

}

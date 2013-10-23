package org.burroloco.butcher.fixture.checker.log;

import org.junit.Assert;

public final class LogChecker {

    private static LogMatcher matcher = new LogMatcher();

    private LogChecker() {
    }

    public static void checkLogContains(String pattern) {
        if (matcher.matches(pattern)) return;
        Assert.fail("Checked the logs but can't find " + pattern);
    }
}
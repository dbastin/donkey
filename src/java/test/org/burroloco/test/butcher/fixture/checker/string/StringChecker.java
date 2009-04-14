package org.burroloco.test.butcher.fixture.checker.string;

import org.burroloco.test.butcher.fixture.checker.type.Occurrence;

public interface StringChecker {
    void check(String content, String... expectations);

    void check(String content, Occurrence type, String... expectations);
}

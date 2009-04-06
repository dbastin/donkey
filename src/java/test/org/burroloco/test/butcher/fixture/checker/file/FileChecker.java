package org.burroloco.test.butcher.fixture.checker.file;

import org.burroloco.test.butcher.fixture.checker.type.Occurence;

import java.io.File;

public interface FileChecker {
    void check(File file, String... expectations);
    void check(File file, Occurence type, String... expectations);
}

package org.burroloco.butcher.fixture.checker.file;

import org.burroloco.butcher.fixture.checker.type.Occurrence;

import java.io.File;

public interface FileChecker {
    void check(File file, String... expectations);
    void check(File file, Occurrence type, String... expectations);
}

package org.burroloco.butcher.fixture.checker.file;

import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.butcher.fixture.checker.string.StringChecker;
import org.burroloco.butcher.fixture.checker.type.Occurrence;

import java.io.File;

import static org.burroloco.butcher.fixture.checker.type.Occurrence.ONCE;

public class DefaultFileChecker implements FileChecker {
    FileUtilsStatic fileUtil;
    StringChecker checker;

    public void check(File file, String... expectations) {
        check(file, ONCE, expectations);
    }

    public void check(File file, Occurrence type, String... expectations) {
        String content = fileUtil.readFileToString(file);
        checker.check(content, type, expectations);
    }
}

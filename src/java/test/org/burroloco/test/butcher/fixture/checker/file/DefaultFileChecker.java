package org.burroloco.test.butcher.fixture.checker.file;

import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.test.butcher.fixture.checker.string.StringChecker;
import org.burroloco.test.butcher.fixture.checker.type.Occurence;
import static org.burroloco.test.butcher.fixture.checker.type.Occurence.ONCE;

import java.io.File;

public class DefaultFileChecker implements FileChecker {
    FileUtilsStatic fileUtil;
    StringChecker checker;

    public void check(File file, String... expectations) {
        check(file, ONCE, expectations);
    }

    public void check(File file, Occurence type, String... expectations) {
        String content = fileUtil.readFileToString(file);
        checker.check(content, type, expectations);
    }
}

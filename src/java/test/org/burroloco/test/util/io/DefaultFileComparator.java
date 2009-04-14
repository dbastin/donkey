package org.burroloco.test.util.io;

import edge.org.apache.commons.io.FileUtilsStatic;
import junit.framework.Assert;
import org.burroloco.test.constants.TestConstants;

import java.io.File;

public class DefaultFileComparator implements FileComparator, TestConstants {
    FileUtilsStatic fileUtil;

    public void assertEquals(File expected, File actual) {
        String e = read(expected);
        String a = read(actual);
        Assert.assertEquals(e, a);
    }

    private String read(File file) {
        String raw = fileUtil.readFileToString(file);
        return normalize(dates(raw));
    }

    private String dates(String withDates) {
        return withDates.replaceAll(DATE_PATTERN_SLASH_DMY, DAVES_BIRTHDAY_SLASH);
    }

    // FIX-DONKEY own component or StringChecker?
    private String normalize(String raw) {
        return raw.replaceAll("\\r\\n", "\n");
    }
}

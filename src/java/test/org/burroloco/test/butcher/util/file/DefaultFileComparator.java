package org.burroloco.test.butcher.util.file;

import edge.org.apache.commons.io.FileUtilsStatic;
import junit.framework.Assert;
import org.burroloco.test.glue.constants.TestConstants;
import org.burroloco.test.butcher.fixture.checker.string.Normaliser;

import java.io.File;

public class DefaultFileComparator implements FileComparator, TestConstants {
    FileUtilsStatic fileUtil;
    Normaliser normaliser;

    public void assertEquals(File expected, File actual) {
        String e = read(expected);
        String a = read(actual);
        Assert.assertEquals(e, a);
    }

    private String read(File file) {
        String raw = fileUtil.readFileToString(file);
        return normaliser.normalise(dates(raw));
    }

    private String dates(String withDates) {
        return withDates.replaceAll(DATE_PATTERN_SLASH_DMY, DAVES_BIRTHDAY_SLASH);
    }
}

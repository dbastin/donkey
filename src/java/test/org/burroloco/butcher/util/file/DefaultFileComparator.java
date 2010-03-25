package org.burroloco.butcher.util.file;

import edge.org.apache.commons.io.FileUtilsStatic;
import junit.framework.Assert;
import org.burroloco.butcher.fixture.checker.string.Normaliser;
import org.burroloco.butcher.glue.constants.ButcherTestConstants;

import java.io.File;

public class DefaultFileComparator implements FileComparator, ButcherTestConstants {
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
        String output = withDates.replaceAll(DATE_PATTERN_SLASH_DMY, DAVES_BIRTHDAY_SLASH);
        return output.replaceAll(DATE_PATTERN_SLASH_YMDHMS, DAVES_BIRTHDAYTIME_SLASH);
    }
}

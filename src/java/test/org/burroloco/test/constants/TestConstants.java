package org.burroloco.test.constants;

import java.io.File;


public interface TestConstants {
    File LOG = new File("gen/artifacts/test/log/donkey.log");
    File DIST = new File("gen/artifacts/test");
    long ONE_SECOND = 1000;
    String DAVES_BIRTHDAY_SLASH = "24/01/1980";
    String DAVES_BIRTHDAY_DASH = "1980-01-24";
    String DATE_PATTERN_SLASH_DMY = "(?m)\\d{2}/\\d{2}/\\d{4}";
}

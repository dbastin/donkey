package org.burroloco.test.constants;

import java.io.File;


public interface TestConstants {
    String TEST_BASE_PATH = "gen/artifacts/test/";
    String DIST_BASE_PATH = TEST_BASE_PATH + "dist/";
    String INTERFACE = "interface/";
    File TMP_DIR = new File(System.getProperty("java.io.tmpdir"));
    File LOG = new File("gen/artifacts/test/log/donkey.log");
    long ONE_SECOND = 1000;
    long THIRTY_SECONDS = 30 * ONE_SECOND;
    String DONT_CARE = "DONT_CARE";
    int MAX_ROWS = 10;
    String DAVES_BIRTHDAY_SLASH = "24/01/1980";
    String DAVES_BIRTHDAY_DASH = "1980-01-24";
    String DATE_PATTERN_SLASH_DMY = "(?m)\\d{2}/\\d{2}/\\d{4}";
    String DATE_PATTERN_DASH_YMD = "(?m)\\d{4}-\\d{2}-\\d{2}";
}

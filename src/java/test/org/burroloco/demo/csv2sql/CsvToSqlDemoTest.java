package org.burroloco.demo.csv2sql;

import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

import java.io.File;

public class CsvToSqlDemoTest extends DonkeyTestCase {
    private static final File ACTUAL = new File("gen/test/out/employee.sql");
    private static final File EXPECTED = new File("data/expected/employee.sql");
    FileUtilsStatic fileUtils;
    Trebuchet trebuchet;

    public void testCsvToSql() {
        trebuchet.launch(CsvToSqlSpecification.class);
        check();
    }

    private void check() {
        String expected = normalize(fileUtils.readFileToString(EXPECTED));
        String actual = normalize(fileUtils.readFileToString(ACTUAL));
        assertEquals(expected, actual);
    }

    // FIX-DONKEY own component or StringChecker?
    private String normalize(String raw) {
        return raw.replaceAll("\\r\\n", "\n");
    }
}

package org.burroloco.demo.csv2sql;

import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.glue.testcase.TsrTestCase;
import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;

public class CsvToSqlDemoTest extends TsrTestCase {
    private static final File ACTUAL = new File("gen/artifacts/test/out/employee.sql");
    private static final File EXPECTED = new File("data/expected/employee.sql");
    FileUtilsStatic fileUtils;
    Trebuchet trebuchet;

    public void testCsvToSql() {
        trebuchet.launch(CsvToSqlJob.class);
        String expected = fileUtils.readFileToString(EXPECTED);
        String actual = fileUtils.readFileToString(ACTUAL);
        assertEquals(expected, actual);
    }
}

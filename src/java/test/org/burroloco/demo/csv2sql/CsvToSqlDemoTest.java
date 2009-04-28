package org.burroloco.demo.csv2sql;

import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.butcher.util.io.FileComparator;

import java.io.File;

public class CsvToSqlDemoTest extends DonkeyTestCase {
    private static final File EXPECTED = new File("data/expected/employee-insert.sql");
    private static final File ACTUAL = new File("gen/demo/out/employee-insert.sql");
    FileComparator comparator;
    Trebuchet trebuchet;

    public void testCsvToSql() {
        trebuchet.launch(CsvToSqlSpecification.class);
        comparator.assertEquals(EXPECTED, ACTUAL);
    }
}

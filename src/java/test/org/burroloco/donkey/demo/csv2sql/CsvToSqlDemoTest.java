package org.burroloco.donkey.demo.csv2sql;

import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.Trebuchet;

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

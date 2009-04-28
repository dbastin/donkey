package org.burroloco.donkey.demo.filemeta2fixed;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.butcher.util.file.FileComparator;

import java.io.File;

public class FileMetadataToFixedWidthDemoTest extends DonkeyTestCase implements HasFixtures {
    private static final File EXPECTED = new File("data/expected/directory-report.fixed");
    private static final File OUT = new File("gen/demo/out");
    private static final File ACTUAL = new File(OUT, "directory-report.fixed");
    FileUtilsStatic fileUtils;
    FileComparator comparator;
    Trebuchet trebuchet;

    public void fixtures() {
        OUT.mkdirs();
        fileUtils.cleanDirectory(OUT);
    }

    public void testDirectoryToFixedWidth() {
        trebuchet.launch(FileMetadataToFixedWidthSpecification.class);
        comparator.assertEquals(EXPECTED, ACTUAL);
    }
}

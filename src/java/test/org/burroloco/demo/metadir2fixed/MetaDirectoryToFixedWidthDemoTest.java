package org.burroloco.demo.metadir2fixed;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;

import java.io.File;

public class MetaDirectoryToFixedWidthDemoTest extends DonkeyTestCase implements HasFixtures {
    private static final File EXPECTED = new File("data/expected/directory-report.fixed");
    private static final File ACTUAL = new File("gen/test/out/directory-report.fixed");
    private static final File OUT = new File("gen/test/out");
    FileUtilsStatic fileUtils;
    FileComparator comparator;
    Trebuchet trebuchet;

    public void fixtures() {
        OUT.mkdirs();
        fileUtils.cleanDirectory(OUT);
    }

    public void testDirectoryToFixedWidth() {
        trebuchet.launch(MetaDirectoryToFixedWidthSpecification.class);
        comparator.assertEquals(EXPECTED, ACTUAL);
    }
}

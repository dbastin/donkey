package org.burroloco.demo.errors;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;

import java.io.File;

public class ErrorHandlingDemoTest extends DonkeyTestCase implements HasFixtures {
    private static final File DODGY = new File("data/input/dodgy.csv");
    private static final File IN = new File("gen/demo/in");
    private static final File ERROR = new File("gen/demo/error");
    //SIMIAN OFF
    FileUtilsStatic fileUtils;
    FileComparator comparator;
    Trebuchet trebuchet;
    //SIMIAN ON

    public void fixtures() {
        ERROR.mkdirs();
        fileUtils.cleanDirectory(ERROR);
        fileUtils.copyFileToDirectory(DODGY, IN);
    }

    public void testBadInputData() {
        trebuchet.launch(ErrorHandlingSpecification.class);
        checkDodgyHasMoved();
    }

    private void checkDodgyHasMoved() {
        assertEquals(0, IN.listFiles().length);
        File actual = ERROR.listFiles()[0];
        comparator.assertEquals(DODGY, actual);
    }
}

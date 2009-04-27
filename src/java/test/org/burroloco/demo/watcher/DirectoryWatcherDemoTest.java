package org.burroloco.demo.watcher;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.trebuchet.TestTrebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;

public class DirectoryWatcherDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private static final File NONE = new File("");
    private static final File INPUT = new File("data/input/employee.csv");
    private static final File DODGY = new File("data/input/dodgy.csv");
    private static final File IN = new File("gen/demo/in");
    private static final File OUT = new File("gen/demo/out");
    private static final File ERROR = new File("gen/demo/error");
    private static final File COMPLETED = new File("gen/demo/completed");
    private static final File EXPECTED = new File("data/expected/employee-insert.sql");
    FileUtilsStatic fileUtils;
    FileComparator comparator;
    TestTrebuchet trebuchet;
    Snoozer snoozer;

    public void fixtures() {
        makeDirs();
        cleanDirs();
    }

    public void testSuccess() {
        launchDonkey();
        checkSuccess(3);
    }

    public void testBadInputData() {
        launchDonkey();
        checkFailure(2);
    }

    private void cleanDirs() {
        fileUtils.cleanDirectory(IN);
        fileUtils.cleanDirectory(OUT);
        fileUtils.cleanDirectory(ERROR);
        fileUtils.cleanDirectory(COMPLETED);
    }

    private void makeDirs() {
        IN.mkdirs();
        OUT.mkdirs();
        ERROR.mkdirs();
        COMPLETED.mkdirs();
    }

    private void launchDonkey() {
        Class spec = DirectoryWatcherSpecification.class;
        trebuchet.launch(spec, DirectoryWatcherTestWeb.class);
    }

    private void checkSuccess(int times) {
        for (int i = 1; i <= times; i++) {
            dropFile(INPUT);
            checkDir(0, IN, NONE);
            checkDir(i, OUT, EXPECTED);
            checkDir(0, ERROR, NONE);
            checkDir(i, COMPLETED, INPUT);
        }
    }

    private void checkFailure(int times) {
        for (int i = 1; i <= times; i++) {
            dropFile(DODGY);
            checkDir(0, IN, NONE);
            checkDir(0, OUT, NONE);
            checkDir(i, ERROR, DODGY);
            checkDir(0, COMPLETED, NONE);
        }
    }

    private void dropFile(File input) {
        fileUtils.copyFileToDirectory(input, IN);
        snoozer.snooze(1300);
    }

    private void checkDir(int i, File dir, File expected) {
        File[] files = dir.listFiles();
        assertEquals(i, files.length);
        for (File actual : files) {
            comparator.assertEquals(expected, actual);
        }
    }

    public void destroy() {
        Stop job = spider.resolve(Stop.class);
        job.stop();
    }
}
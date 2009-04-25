package org.burroloco.demo.watcher;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.trebuchet.TestTrebuchet;
import org.burroloco.test.butcher.fixture.checker.string.Normaliser;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;

public class DirectoryWatcherDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private static final File INPUT = new File("data/input/employee.csv");
    private static final File IN = new File("gen/demo/in");
    private static final File OUT = new File("gen/demo/out");
    private static final File COMPLETED = new File("gen/demo/completed");
    private static final File ACTUAL = new File(OUT, "employee-insert.sql");
    private static final File EXPECTED = new File("data/expected/employee-insert.sql");
    FileUtilsStatic fileUtils;
    TestTrebuchet trebuchet;
    FileComparator comparator;
    Normaliser normaliser;
    Snoozer snoozer;
    Impl impl;
    Nu nu;

    public void fixtures() {
        IN.mkdirs();
        OUT.mkdirs();
        COMPLETED.mkdirs();
        fileUtils.cleanDirectory(IN);
        fileUtils.cleanDirectory(OUT);
        fileUtils.cleanDirectory(COMPLETED);
    }

    public void testDirectoryWatcher() {
        Class spec = DirectoryWatcherSpecification.class;
        trebuchet.launch(spec, DirectoryWatcherTestWeb.class);
        repeat(3);
    }

    private void repeat(int times) {
        for (int i = 1; i <= times; i++) {
            dropFile();
            checkInDir();
            checkOutDir();
            checkCompletedDir(i);
        }
    }

    private void dropFile() {
        fileUtils.copyFileToDirectory(INPUT, IN);
        snoozer.snooze(1000);
    }

    private void checkInDir() {
        int inboxFileCount = IN.listFiles().length;
        assertEquals(0, inboxFileCount);
    }

    private void checkOutDir() {
        comparator.assertEquals(EXPECTED, ACTUAL);
    }

    private void checkCompletedDir(int i) {
        File[] completedFiles = COMPLETED.listFiles();
        assertEquals(i, completedFiles.length);
        for (File file : completedFiles) {
            comparator.assertEquals(INPUT, file);
        }
    }

    public void destroy() {
        Stop job = spider.resolve(Stop.class);
        job.stop();
    }
}
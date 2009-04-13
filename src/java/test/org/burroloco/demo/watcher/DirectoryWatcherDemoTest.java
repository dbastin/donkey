package org.burroloco.demo.watcher;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.input.watcher.DirectoryWatcher;
import org.burroloco.donkey.input.watcher.WatcherTestWeb;
import org.burroloco.donkey.trebuchet.TestTrebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.snooze.Snoozer;

import java.io.File;

public class DirectoryWatcherDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private static final File INPUT = new File("data/input/employee.csv");
    private static final File IN = new File("gen/test/in");
    private static final File OUT = new File("gen/test/out");
    private static final File COMPLETED = new File("gen/test/completed");
    private static final File ACTUAL = new File(OUT, "employee.sql");
    private static final File EXPECTED = new File("data/expected/employee.sql");
    FileUtilsStatic fileUtils;
    TestTrebuchet trebuchet;
    Snoozer snoozer;

    public void fixtures() {
        IN.mkdirs();
        OUT.mkdirs();
        COMPLETED.mkdirs();
        fileUtils.cleanDirectory(IN);
        fileUtils.cleanDirectory(OUT);
        fileUtils.cleanDirectory(COMPLETED);
    }

    public void testDirectoryWatcher() {
        Class watcherJob = DirectoryWatcherJobSpec.class;
        trebuchet.launch(watcherJob, WatcherTestWeb.class);
        repeat(3);
    }

    public void destroy() {
        DirectoryWatcher watcher = spider.resolve(DirectoryWatcher.class);
        watcher.stop();
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
        String expected = fileUtils.readFileToString(EXPECTED);
        String actual = fileUtils.readFileToString(ACTUAL);
        assertEquals(expected, actual);
    }

    private void checkCompletedDir(int i) {
        String expected = fileUtils.readFileToString(INPUT);
        File[] completedFiles = COMPLETED.listFiles();
        assertEquals(i, completedFiles.length);
        for (File file : completedFiles) {
            String actual = fileUtils.readFileToString(file);
            assertEquals(expected, actual);
        }
    }
}
package org.burroloco.test.butcher.fixture.checker.file;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.sniper.core.Test;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.test.butcher.fixture.checker.type.Occurence;

import java.io.File;


// TSR-3629 Replace this with isolated test logs using MDC.
public class ShiftingFileChecker implements PollingFileChecker {
    PollingFileChecker delegate;
    FileUtilsStatic files;
    Test test;
    Log log;

    public void check(File file, String... expectations) {
        try {
            delegate.check(file, expectations);
        } catch (RuntimeException e) {
            embalm(file);
            throw e;
        }
    }

    public void check(File file, Occurence type, String... expectations) {
        try {
            delegate.check(file, type, expectations);
        } catch (RuntimeException e) {
            embalm(file);
            throw e;
        }
    }

     private void embalm(File file) {
        String id = test.toString().replace('(', '.').replace(")", "");
        File target = new File(file.getAbsolutePath() + "." + id);
        target.delete();
        files.moveFile(file, target);
        log.info("Failure detected, embalming log for posterity. Tomb: " + target.getAbsolutePath());
    }
}

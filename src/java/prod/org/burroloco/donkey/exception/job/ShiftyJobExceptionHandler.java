package org.burroloco.donkey.exception.job;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.util.FileShifter;

public class ShiftyJobExceptionHandler implements JobExceptionHandler {
    JobExceptionHandler delegate;
    FileShifter shifty;
    WeakConfig weak;

    public void error(Config config, RuntimeException e) {
        String source = weak.get(config, InputFileName.class);
        String targetDir = weak.get(config, ErrorDirName.class);
        shifty.stampAndMove(source, targetDir);
        delegate.error(config, e);
    }
}

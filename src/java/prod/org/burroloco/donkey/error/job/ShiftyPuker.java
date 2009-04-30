package org.burroloco.donkey.error.job;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.util.FileShifter;

public class ShiftyPuker implements Puker {
    FileShifter shifty;
    WeakConfig weak;
    Puker delegate;

    public void error(Config config, RuntimeException e) {
        String source = weak.get(config, InputFileName.class);
        String targetDir = weak.get(config, ErrorDirName.class);
        shifty.stampAndMove(source, targetDir);
        delegate.error(config, e);
    }
}

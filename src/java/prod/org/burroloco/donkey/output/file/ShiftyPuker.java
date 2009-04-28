package org.burroloco.donkey.output.file;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.puker.Puker;
import org.burroloco.donkey.util.FileShifter;

public class ShiftyPuker implements Puker {
    FileShifter shifty;
    WeakConfig weak;

    public void error(Config config, Exception e) {
        String source = weak.get(config, InputFileName.class);
        String targetDir = weak.get(config, ErrorDirName.class);
        shifty.stampAndMove(source, targetDir);
    }
}

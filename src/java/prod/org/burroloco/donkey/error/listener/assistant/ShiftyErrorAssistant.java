package org.burroloco.donkey.error.listener.assistant;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.util.FileShifter;

// FIX TSR-DONKEY Use or Lose
public class ShiftyErrorAssistant implements ErrorAssistant {
    FileShifter shifty;
    WeakConfig weak;

    public void help(Config config) {
        String source = weak.get(config, InputFileName.class);
        String targetDir = weak.get(config, ErrorDirName.class);
        shifty.stampAndMove(source, targetDir);
    }
}

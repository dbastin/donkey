package org.burroloco.donkey.error.listener.assistant;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.input.file.InputFileNameProvider;
import org.burroloco.donkey.util.FileShifter;

public class ShiftyErrorAssistant implements ErrorAssistant {
    InputFileNameProvider provider;
    FileShifter shifty;
    WeakConfig weak;

    public void help(Config config) {
        String source = provider.weak(config);
        String targetDir = weak.get(config, ErrorDirName.class);
        shifty.stampAndMove(source, targetDir);
    }
}

package org.burroloco.donkey.output.file;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.CompletedDirname;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.file.InputFileNameProvider;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.util.FileShifter;

public class ShiftySpitter implements Spitter {
    InputFileNameProvider provider;
    FileShifter shifty;
    Spitter delegate;
    WeakConfig weak;

    public void pertuh(Config config, Cake cake) {
        delegate.pertuh(config, cake);
        shiftToCompleted(config);
    }

    private void shiftToCompleted(Config config) {
        String source = provider.weak(config);
        String targetDir = weak.get(config, CompletedDirname.class);
        shifty.stampAndMove(source, targetDir);
    }
}
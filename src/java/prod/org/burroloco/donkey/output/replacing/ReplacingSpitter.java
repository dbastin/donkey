package org.burroloco.donkey.output.replacing;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.ConfigDrivenOutputFileWizard;
import org.burroloco.donkey.output.file.FileScribbler;

public class ReplacingSpitter implements Spitter {
    ConfigDrivenOutputFileWizard wizard;
    ExpandingStringer stringer;
    FileScribbler scribbler;

    public void pertuh(Config config, Cake cake) {
        scribbler.scribble(wizard.file(config), stringer.text(config, cake));
    }
}

package org.burroloco.donkey.output.fixedwidth;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.OutputFileWizard;
import org.burroloco.donkey.output.file.Scribbler;

import java.io.File;

public class FixedWidthRecordSpitter implements Spitter {
    FixedWidthRecordStringer stringer;
    OutputFileWizard wizard;
    Scribbler scribbler;

    public void pertuh(Config config, Cake cake) {
        File target = wizard.file(config);
        String text = stringer.build(config, cake);
        scribbler.scribble(target, text);
    }
}

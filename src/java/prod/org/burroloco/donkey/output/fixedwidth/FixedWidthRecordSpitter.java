package org.burroloco.donkey.output.fixedwidth;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.OutputFileWizard;
import org.burroloco.donkey.output.file.Scribbler;

import java.io.File;

public class FixedWidthRecordSpitter implements Spitter {
    FixedWidthRecordStringer stringer;
    OutputFileWizard wizard;
    Scribbler scribbler;

    public void spit(Config config, Data data) {
        File target = wizard.nu(config);
        String text = stringer.build(config, data);
        scribbler.scribble(target, text);
    }
}

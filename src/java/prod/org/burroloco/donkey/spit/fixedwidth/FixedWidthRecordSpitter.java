package org.burroloco.donkey.spit.fixedwidth;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.file.OutputFileWizard;
import org.burroloco.donkey.spit.file.Scribbler;

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

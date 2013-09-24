package org.burroloco.donkey.spit.file;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.template.TemplateStringer;

import java.io.File;

public class FileSpitter implements Spitter {
    OutputFileWizard wizard;
    TemplateStringer stringer;
    Scribbler scribbler;

    public void spit(Config config, Data data) {
        File outFile = wizard.nu(config);
        String text = stringer.text(config, data);
        scribbler.scribble(outFile, text);
    }
}

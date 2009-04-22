package org.burroloco.donkey.output.file;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.replacing.TemplateStringer;

import java.io.File;

public class FileSpitter implements Spitter {
    OutputFileWizard wizard;
    TemplateStringer stringer;
    Scribbler scribbler;

    public void pertuh(Config config, Cake cake) {
        File outFile = wizard.file(config);
        String text = stringer.text(config, cake);
        scribbler.scribble(outFile, text);
    }
}

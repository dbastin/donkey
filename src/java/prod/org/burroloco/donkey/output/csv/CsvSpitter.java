package org.burroloco.donkey.output.csv;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.OutputFileWizard;

import java.io.File;

public class CsvSpitter implements Spitter {
    OutputFileWizard wizard;
    CsvSpitterEngine engine;

    public void pertuh(Config config, Cake cake) {
        File out = wizard.file(config);
        engine.pertuh(out, cake);
    }
}

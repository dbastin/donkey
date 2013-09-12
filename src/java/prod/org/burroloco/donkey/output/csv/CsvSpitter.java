package org.burroloco.donkey.output.csv;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.OutputFileWizard;

import java.io.File;

public class CsvSpitter implements Spitter {
    OutputFileWizard files;
    CsvSpitterEngine engine;

    public void spit(Config config, Data data) {
        File out = files.nu(config);
        engine.spit(out, data);
    }
}

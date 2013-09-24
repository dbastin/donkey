package org.burroloco.donkey.spit.csv;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.file.OutputFileWizard;

import java.io.File;

public class CsvSpitter implements Spitter {
    OutputFileWizard files;
    CsvSpitterEngine engine;

    public void spit(Config config, Data data) {
        File out = files.nu(config);
        engine.spit(out, data);
    }
}

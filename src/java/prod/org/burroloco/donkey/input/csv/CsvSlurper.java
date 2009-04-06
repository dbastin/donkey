package org.burroloco.donkey.input.csv;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.file.InputFileNameProvider;

public class CsvSlurper implements Slurper {
    InputFileNameProvider provider;
    CsvSlurperEngine engine;

    public Cake slurp(Config config) {
        InputFileName in = provider.strong(config);
        return engine.slurp(in);
    }
}

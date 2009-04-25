package org.burroloco.donkey.input.csv;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;

import java.util.List;

public class CsvSlurper implements Slurper {
    ListConverter converter;
    CsvReader reader;

    public Cake slurp(Config config) {
        InputFileName in = config.get(InputFileName.class);
        List rows = reader.read(in);
        return converter.convert(rows);
    }
}

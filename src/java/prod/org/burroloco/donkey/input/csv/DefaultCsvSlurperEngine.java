package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Data;

import java.util.List;

public class DefaultCsvSlurperEngine implements CsvSlurperEngine {
    ListConverter converter;
    CsvReader reader;

    public Data slurp(InputFileName in) {
        List rows = reader.read(in);
        return converter.convert(rows);
    }
}

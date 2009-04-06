package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;

import java.util.List;

public class DefaultCsvSlurperEngine implements CsvSlurperEngine {
    ListConverter converter;
    CsvReader reader;

    public Cake slurp(InputFileName file) {
        List rows = reader.read(file);
        return converter.convert(rows);
    }
}

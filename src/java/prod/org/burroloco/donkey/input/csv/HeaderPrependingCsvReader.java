package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.config.InputFileName;

import java.util.List;

public class HeaderPrependingCsvReader implements CsvReader {
    HeaderPrepender prepender;
    CsvReader reader;

    public List read(InputFileName input) {
        List list = reader.read(input);
        return prepender.prepend(list);
    }
}

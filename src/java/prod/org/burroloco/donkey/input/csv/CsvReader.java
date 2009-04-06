package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.config.InputFileName;

import java.util.List;

public interface CsvReader {
    List read(InputFileName input);
}

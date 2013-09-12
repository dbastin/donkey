package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Data;
import org.burroloco.donkey.output.file.Scribbler;

import java.io.File;

public class DefaultCsvSpitterEngine implements CsvSpitterEngine {
    Scribbler scribbler;
    CsvStringer csv;

    public void spit(File out, Data data) {
        String text = csv.text(data);
        scribbler.scribble(out, text);
    }
}

package org.burroloco.donkey.spit.csv;

import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.spit.file.Scribbler;

import java.io.File;

public class DefaultCsvSpitterEngine implements CsvSpitterEngine {
    Scribbler scribbler;
    CsvStringer csv;

    public void spit(File out, Data data) {
        String text = csv.text(data);
        scribbler.scribble(out, text);
    }
}

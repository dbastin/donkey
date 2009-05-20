package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.file.Scribbler;

import java.io.File;

public class DefaultCsvSpitterEngine implements CsvSpitterEngine {
    Scribbler scribbler;
    CsvStringer csv;

    public void pertuh(File out, Cake cake) {
        String text = csv.text(cake);
        scribbler.scribble(out, text);
    }
}

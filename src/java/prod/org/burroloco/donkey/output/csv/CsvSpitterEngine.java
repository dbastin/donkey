package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;

import java.io.File;

public interface CsvSpitterEngine {
    void pertuh(File out, Cake cake);
}

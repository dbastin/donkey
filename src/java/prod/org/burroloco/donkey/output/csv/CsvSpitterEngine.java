package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Data;

import java.io.File;

public interface CsvSpitterEngine {
    void spit(File out, Data data);
}

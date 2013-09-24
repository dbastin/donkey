package org.burroloco.donkey.spit.csv;

import org.burroloco.donkey.data.core.Data;

import java.io.File;

public interface CsvSpitterEngine {
    void spit(File out, Data data);
}

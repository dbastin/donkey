package org.burroloco.donkey.input.csv;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.au.com.bytecode.opencsv.CSVReader;
import edge.java.io.FileReader;
import org.burroloco.donkey.config.InputFileName;

import java.util.List;

public class DefaultCsvReader implements CsvReader {
    Weaken weaken;
    Nu nu;

    public List read(InputFileName input) {
        FileReader fileReader = nu.nu(FileReader.class, weaken.w(input));
        CSVReader reader = nu.nu(CSVReader.class, fileReader);
        return reader.readAll();
    }
}

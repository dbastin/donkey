package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.csv.CsvSlurperEngine;

public class DefaultArchive implements Archive {
    CsvSlurperEngine slurper;
    Nu nu;

    public Cake get(String name) {
        String location = toLocation(name);
        InputFileName in = nu.nu(InputFileName.class, location);
        return slurper.slurp(in);
    }

    private String toLocation(String name) {
        return "data/archive/" + name + ".csv";
    }
}

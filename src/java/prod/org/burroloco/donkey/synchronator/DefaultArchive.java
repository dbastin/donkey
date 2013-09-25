package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.slurp.csv.CsvSlurperEngine;

import java.io.File;

public class DefaultArchive implements Archive {
    CsvSlurperEngine slurper;
    Weaken weak;
    Nu nu;

    public Data get(String name) {
        String location = toLocation(name);
        InputFileName in = nu.nu(InputFileName.class, location);
        if (!exists(in)) return nu.nu(Data.class);
        return slurper.slurp(in);
    }

    private String toLocation(String name) {
        return "data/archive/" + name + ".csv";
    }

    private boolean exists(InputFileName in) {
        return new File(weak.w(in)).exists();
    }
}

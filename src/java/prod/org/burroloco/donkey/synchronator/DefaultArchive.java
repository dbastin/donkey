package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.csv.CsvSlurperEngine;

import java.io.File;

public class DefaultArchive implements Archive {
    CsvSlurperEngine slurper;
    Weaken weak;
    Nu nu;

    public Cake get(String name) {
        String location = toLocation(name);
        InputFileName in = nu.nu(InputFileName.class, location);
        if (!exists(in)) return nu.nu(Cake.class);
        return slurper.slurp(in);
    }

    private String toLocation(String name) {
        return "data/archive/" + name + ".csv";
    }

    private boolean exists(InputFileName in) {
        return new File(weak.w(in)).exists();
    }
}

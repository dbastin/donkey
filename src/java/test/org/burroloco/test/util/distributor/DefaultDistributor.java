package org.burroloco.test.util.distributor;

import org.burroloco.donkey.trebuchet.AntRunner;

// FIX TSR-DONKEY Write a generic DistributionTest that uses this or something like it.
public class DefaultDistributor implements Distributor {
    AntRunner ant;

    // FIX DONKEY System name.
    public void distribute() {
        String num = "-Denvironment=konst1";
        ant.run("compile", "dist", "unzip", num);
    }

}
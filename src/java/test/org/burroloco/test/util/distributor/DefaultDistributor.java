package org.burroloco.test.util.distributor;

import org.burroloco.donkey.trebuchet.AntRunner;

public class DefaultDistributor implements Distributor {
    AntRunner ant;

    // FIX DONKEY System name.
    public void distribute() {
        String num = "-Denvironment=konst1";
        ant.run("compile", "dist", "unzip", num);
    }

}
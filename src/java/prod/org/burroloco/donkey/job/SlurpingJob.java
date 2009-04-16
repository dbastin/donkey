package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.transformation.gargler.Gargler;

public class SlurpingJob implements Job {
    Slurper slurper;
    Gargler gargler;

    public void go(Config config) {
        Cake slurped = slurper.slurp(config);
        gargler.slosh(config, slurped);
    }
}

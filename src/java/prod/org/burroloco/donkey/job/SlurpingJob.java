package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.transformation.gargler.Gargler;
import org.burroloco.donkey.log.ProcessLogger;

public class SlurpingJob implements Job {
    Slurper slurper;
    Gargler gargler;
    ProcessLogger logger;

    public void go(Config config) {
        logger.logStarted();
        Cake slurped = slurper.slurp(config);
        gargler.slosh(config, slurped);
        logger.logFinished();
    }
}

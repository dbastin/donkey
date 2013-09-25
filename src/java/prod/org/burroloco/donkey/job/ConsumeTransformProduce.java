package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.gargle.DataGargler;
import org.burroloco.donkey.log.ProcessLogger;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.spit.core.Spitter;

public class ConsumeTransformProduce implements Job {
    ProcessLogger logger;
    DataGargler gargler;
    Slurper slurper;
    Spitter spitter;

    public void go(Config config) {
        logger.logStarted();
        Data in = slurper.slurp(config);
        Data out = gargler.gargle(config, in);
        spitter.spit(config, out);
        logger.logFinished();
    }
}

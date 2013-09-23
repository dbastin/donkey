package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.transform.DataGargler;
import org.burroloco.donkey.log.ProcessLogger;

public class ConsumeTransformProduce implements Job {
    ProcessLogger logger;
    Slurper slurper;
    DataGargler gargler;
    Spitter spitter;

    public void go(Config config) {
        logger.logStarted();
        Data in = slurper.slurp(config);
        Data out = gargler.gargle(config, in);
        spitter.spit(config, out);
        logger.logFinished();
    }
}

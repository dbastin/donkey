package org.burroloco.donkey.core;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.error.listener.core.ErrorEventListener;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.transformation.gargler.Gargler;

public class DefaultJob implements Job {
    ErrorEventListener error;
    ThrowableMaster chuckie;
    Slurper slurper;
    Gargler gargler;
    Spitter spitter;

    public void go(Config config) {
        try {
            Cake slurped = slurper.slurp(config);
            Cake sloshed = gargler.slosh(config, slurped);
            spitter.pertuh(config, sloshed);
        } catch (RuntimeException e) {
            error.onError(config);
            chuckie.rethrow(chuckie.rootCause(e));
        }
    }
}

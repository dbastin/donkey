package org.burroloco.donkey.job;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.error.listener.core.ErrorEventListener;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.transformation.gargler.Gargler;

public class DefaultJob implements Job {
    ErrorEventListener error;
    ThrowableMaster chuckie;
    Slurper slurper;
    Gargler gargler;

    public void go(Config config) {
        try {
            Cake slurped = slurper.slurp(config);
            gargler.slosh(config, slurped);
        } catch (RuntimeException e) {
            error.onError(config);
            chuckie.rethrow(chuckie.rootCause(e));
        }
    }
}

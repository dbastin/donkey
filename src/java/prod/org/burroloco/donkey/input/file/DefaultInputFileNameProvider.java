package org.burroloco.donkey.input.file;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;

public class DefaultInputFileNameProvider implements InputFileNameProvider {
    Weaken weaken;

    public InputFileName strong(Config config) {
        return config.get(InputFileName.class);
    }

    // FIX TSR-DONKEY Use or Lose
    public String weak(Config config) {
        return weaken.w(strong(config));    
    }
}

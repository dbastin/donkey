package org.burroloco.donkey.input.file;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.gunge.thread.Threaded;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;

public class ReferenceInputFileNameProvider implements InputFileNameProvider {
    Threaded<InputFileName> name;
    Weaken weaken;

    public InputFileName strong(Config config) {
        return name.get();
    }

    public String weak(Config config) {
        return weaken.w(strong(config));
    }
}

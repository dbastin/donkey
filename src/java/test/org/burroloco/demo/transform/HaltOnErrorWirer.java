package org.burroloco.demo.transform;

import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.donkey.output.file.FileSpitter;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.config.core.Config;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

public class HaltOnErrorWirer implements Wirer {
    Wire wire;

    public void wire(Config config) {
        wire.cls(BarfingTransform.class).to(Transform.class);
        wire.cls(FileSpitter.class).to(Spitter.class);
    }
}

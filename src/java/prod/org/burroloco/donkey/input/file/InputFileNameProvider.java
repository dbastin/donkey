package org.burroloco.donkey.input.file;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;

public interface InputFileNameProvider {
    InputFileName strong(Config config);
    String weak(Config config);
}

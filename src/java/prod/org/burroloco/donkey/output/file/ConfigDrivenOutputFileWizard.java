package org.burroloco.donkey.output.file;

import org.burroloco.config.core.Config;

import java.io.File;

public interface ConfigDrivenOutputFileWizard {
    File file(Config config);
}

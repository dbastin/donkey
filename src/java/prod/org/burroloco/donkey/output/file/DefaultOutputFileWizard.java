package org.burroloco.donkey.output.file;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.OutputDirName;
import org.burroloco.donkey.config.OutputExtension;
import org.burroloco.donkey.config.OutputName;

import java.io.File;

public class DefaultOutputFileWizard implements OutputFileWizard {
    FileWizard files;
    WeakConfig weak;

    public File file(Config config) {
        String dirname = weak.get(config, OutputDirName.class);
        String filename = weak.get(config, OutputName.class);
        String extension = weak.get(config, OutputExtension.class);
        return files.file(dirname, filename, extension);
    }
}

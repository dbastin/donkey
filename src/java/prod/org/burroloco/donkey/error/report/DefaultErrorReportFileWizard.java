package org.burroloco.donkey.error.report;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.ErrorReportDirName;
import org.burroloco.donkey.config.OutputName;
import org.burroloco.donkey.output.file.FileWizard;

import java.io.File;

// FIX TSR-DONKEY Use or Lose
public class DefaultErrorReportFileWizard implements ErrorReportFileWizard {
    FileWizard wizard;
    WeakConfig weak;

    public File file(Config config) {
        String dirname = weak.get(config, ErrorReportDirName.class);
        String filename = weak.get(config, OutputName.class);
        return wizard.file(dirname, filename + "-errors", "txt");
    }
}

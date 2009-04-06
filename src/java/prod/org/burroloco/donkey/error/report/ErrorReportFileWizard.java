package org.burroloco.donkey.error.report;

import org.burroloco.config.core.Config;

import java.io.File;

public interface ErrorReportFileWizard {
    File file(Config config);
}

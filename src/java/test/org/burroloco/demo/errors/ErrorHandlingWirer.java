package org.burroloco.demo.errors;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;
import org.burroloco.demo.csv2sql.CsvToSqlWirer;
import org.burroloco.donkey.error.listener.core.ErrorHandler;
import org.burroloco.donkey.error.listener.core.SafeErrorHandler;
import org.burroloco.donkey.error.report.ErrorReportFileWizard;
import org.burroloco.donkey.output.file.ShiftyErrorHandler;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class ErrorHandlingWirer implements Wirer {
    ErrorReportFileWizard wizard;
    Impl impl;
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        CsvToSqlWirer base = impl.impl(CsvToSqlWirer.class);
        base.wire(config);
        dna.strand(ErrorHandler.class, SafeErrorHandler.class, ShiftyErrorHandler.class);
    }
}

package org.burroloco.demo.errors;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;
import org.burroloco.demo.csv2sql.CsvToSqlWirer;
import org.burroloco.donkey.error.listener.core.ErrorHandler;
import org.burroloco.donkey.error.listener.core.SafeErrorHandler;
import org.burroloco.donkey.output.file.ShiftyErrorHandler;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class ErrorHandlingWirer implements Wirer {
    Impl impl;
    Dna dna;

    public void wire(Config config) {
        useAnotherWirer(config);
        handleBadInput();
    }

    private void useAnotherWirer(Config config) {
        CsvToSqlWirer another = impl.impl(CsvToSqlWirer.class);
        another.wire(config);
    }

    private void handleBadInput() {
        dna.strand(ErrorHandler.class, SafeErrorHandler.class, ShiftyErrorHandler.class);
    }
}

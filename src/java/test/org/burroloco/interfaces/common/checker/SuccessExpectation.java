package org.burroloco.interfaces.common.checker;

import java.io.File;

public interface SuccessExpectation extends IncomingExpectation {
    String[] SUCCESS_LOGGING = new String[]{
            "Process started",
            "Reading data from",
            "Writing output to",
            "Moving.*to.*completed",
            "Process completed successfully"
    };

    File file();
}

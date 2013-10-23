package org.burroloco.donkey.spit.http;

import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.data.core.Tuple;

public interface HttpErrorHandler {
    void handle(Tuple t, int status, ErrorDirName dir);
}

package org.burroloco.donkey.spit.http;

import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.config.HttpsUrl;
import org.burroloco.donkey.data.core.Tuple;

public interface HttpErrorHandler {
    void handle(Tuple t, ErrorDirName dir, HttpsUrl url, int status);
}

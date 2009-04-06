package org.burroloco.donkey.log;

import java.io.File;

public interface LogCleaner {
    void clean();

    void clean(String filename);

    void clean(File log);
}

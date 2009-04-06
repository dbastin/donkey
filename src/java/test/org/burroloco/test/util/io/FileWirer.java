package org.burroloco.test.util.io;

import java.io.File;

public interface FileWirer {
    File file(String relativePath);

    String path(String relativePath);

    File basedir();
}

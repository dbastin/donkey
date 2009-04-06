package org.burroloco.test.util.io;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import org.burroloco.test.glue.type.Basedir;

import java.io.File;

public class DefaultFileWirer implements FileWirer {
    Basedir basedir;
    Weaken weaken;

    public File file(String relativePath) {
        String basePath = weaken.w(basedir);
        return new File(basePath, relativePath);
    }

    public String path(String relativePath) {
        return file(relativePath).getAbsolutePath();
    }

    public File basedir() {
        return new File(weaken.w(basedir));
    }
}

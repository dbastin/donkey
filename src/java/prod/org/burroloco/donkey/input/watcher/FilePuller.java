package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.bullet.farmer.Pull;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import org.burroloco.donkey.config.InputDirName;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FilePuller implements Pull<List<File>> {
    private InputDirName name;
    Weaken weaken;

    public FilePuller(InputDirName name) {
        this.name = name;
    }

    public List<File> pull() {
        File dir = new File(weaken.w(name));
        if (!dir.isDirectory()) pop(dir);
        File[] files = dir.listFiles();
        return Arrays.asList(files);
    }

    private void pop(File file) {
        String invalid = file.getPath();
        throw new IllegalArgumentException(invalid + " is not a valid directory.");
    }
}

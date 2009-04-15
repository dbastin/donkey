package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.bullet.farmer.Pull;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import org.burroloco.donkey.config.InputDirName;

import java.io.File;
import java.util.List;

public class FilePuller implements Pull<List<File>> {
    private InputDirName name;
    FileListing listing;
    Weaken weaken;

    public FilePuller(InputDirName name) {
        this.name = name;
    }

    public List<File> pull() {
        File dir = new File(weaken.w(name));
        return listing.list(dir);
    }
}

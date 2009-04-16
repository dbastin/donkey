package org.burroloco.donkey.input.file;

import java.io.File;
import java.util.List;

public interface FileListing {
    List<File> list(File dir);
}

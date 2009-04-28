package org.burroloco.test.butcher.util.dir;

import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.util.List;

public interface DirectoryScanner {
    List<File> allFiles(File dir, IOFileFilter filter);

    List<File> allFiles(File dir, String ext);

    List<String> allFileNames(File dir, String ext);
}

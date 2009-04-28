package org.burroloco.test.butcher.util.dir;

import static org.apache.commons.io.FileUtils.listFiles;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultDirectoryScanner implements DirectoryScanner {

    public List<File> allFiles(File dir, IOFileFilter filter) {
        IOFileFilter allDirs = FileFilterUtils.directoryFileFilter();
        Collection collection = listFiles(dir, filter, allDirs);
        return new ArrayList(collection);
    }

    public List<File> allFiles(File dir, final String ext) {
        File[] files = find(dir, ext);
        List<File> list = files != null ? Arrays.asList(files) : new ArrayList<File>();
        sort(list);
        return list;
    }

    public List<String> allFileNames(File dir, final String ext) {
        List<File> files = allFiles(dir, new SuffixFileFilter(ext));
        return stripExtensions(files, ext);
    }
    
    private List<String> stripExtensions(Iterable<File> files, String ext) {
        List<String> names = new ArrayList<String>();
        for (File file : files) {
            String filename = file.getName();
            String name = filename.substring(0, filename.indexOf(ext));
            names.add(name);
        }
        return names;
    }


    private void sort(List<File> list) {
        Collections.sort(list, new Comparator<File>() {
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    private File[] find(File dir, final String ext) {
        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }
        });
    }
}

package edge.org.apache.commons.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.util.Collection;
import java.util.List;

public interface FileUtilsStatic extends Edge {
    void cleanDirectory(File file);

    void copyFile(File copiedFile, File localFile);

    void copyFileToDirectory(File source, File target);

    void moveFileToDirectory(File source, File target, boolean createDir);

    void moveFile(File source, File target);

    String readFileToString(File file);

    long sizeOfDirectory(File dir);

    void writeStringToFile(File file, String s);

    Collection listFiles(File directory, IOFileFilter fileFilter, IOFileFilter dirFilter);

    List readLines(File file);

    byte[] readFileToByteArray(File file);

    void touch(File file);
}
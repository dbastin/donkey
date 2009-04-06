package edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.io.File;

public interface FileStatic extends Edge {
    File createTempFile(String prefix, String suffix);
    File createTempFile(String prefix, String suffix, File directory);
}

package edge.java.lang;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.io.File;

public interface Runtime extends Edge {
    Process exec(String[] command, String[] vars, File dir);
}

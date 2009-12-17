package edge.au.com.bytecode.opencsv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.util.List;

public interface CSVReader extends Edge {
    void close();
    List readAll();
    String[] readNext();
    
}

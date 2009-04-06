package edge.org.dbunit.database.statement;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface IBatchStatement extends Edge {
    void addBatch(String sql);

    int executeBatch();

    void clearBatch();

    void close();
}

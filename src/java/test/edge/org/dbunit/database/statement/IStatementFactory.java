package edge.org.dbunit.database.statement;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.dbunit.database.IDatabaseConnection;

public interface IStatementFactory extends Edge {
    IBatchStatement createBatchStatement(IDatabaseConnection connection);
}

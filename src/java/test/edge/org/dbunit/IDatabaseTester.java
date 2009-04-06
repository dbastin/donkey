package edge.org.dbunit;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.dbunit.database.IDatabaseConnection;

public interface IDatabaseTester extends Edge {
    IDatabaseConnection getConnection();
}

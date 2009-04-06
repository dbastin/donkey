package edge.org.dbunit.operation;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.IDataSet;

public interface DatabaseOperation extends Edge {
    void execute(IDatabaseConnection con, IDataSet data);
}

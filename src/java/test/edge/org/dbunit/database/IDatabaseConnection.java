package edge.org.dbunit.database;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.dbunit.database.statement.IStatementFactory;
import edge.org.dbunit.dataset.ITable;
import org.dbunit.database.DatabaseConfig;

public interface IDatabaseConnection extends Edge {
    ITable createQueryTable(String resultSetName, String sql);

    DatabaseConfig getConfig();

    int getRowCount(String tableName);

    IStatementFactory getStatementFactory();

    void close();
}

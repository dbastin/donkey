package edge.org.dbunit.dataset;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface IDataSet extends Edge {
    ITableMetaData getTableMetaData(String tableName);
}

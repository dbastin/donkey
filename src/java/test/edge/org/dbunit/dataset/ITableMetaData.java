package edge.org.dbunit.dataset;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface ITableMetaData extends Edge  {
    Column[] getColumns();
}

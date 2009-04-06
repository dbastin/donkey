package edge.org.dbunit.dataset;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;

public interface ITable extends Edge, Unedgable {
    Object getValue(int row, String column);

    int getRowCount();

    ITableMetaData getTableMetaData();
}

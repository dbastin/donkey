package org.burroloco.butcher.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.IDataSet;
import edge.org.dbunit.dataset.ITableMetaData;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.filter.IColumnFilter;

public class DefaultPrimaryKeyColumnFilter implements PrimaryKeyColumnFilter {
    private static final String FILTER = "http://www.dbunit.org/properties/primaryKeyFilter";

    public void set(IDatabaseConnection connection, IDataSet dataSet) {
        DatabaseConfig config = connection.getConfig();
        config.setProperty(FILTER, new PrimaryKeyFilter(dataSet));
    }

    private class PrimaryKeyFilter implements IColumnFilter {
        private IDataSet dataSet;

        public PrimaryKeyFilter(IDataSet dataSet) {
            this.dataSet = dataSet;
        }

        public boolean accept(String tableName, Column column) {
            String name = firstColumn(tableName);
            return isFirstColumn(column, name);
        }

        private boolean isFirstColumn(Column column, String name) {
            return name.equalsIgnoreCase(column.getColumnName());
        }

        private String firstColumn(String tableName) {
            ITableMetaData md = dataSet.getTableMetaData(tableName);
            edge.org.dbunit.dataset.Column first = md.getColumns()[0];
            return first.getColumnName();
        }
    }
}

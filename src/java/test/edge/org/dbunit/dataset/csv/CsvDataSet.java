package edge.org.dbunit.dataset.csv;

import edge.org.dbunit.dataset.IDataSet;
import edge.org.dbunit.dataset.ITable;

public interface CsvDataSet extends IDataSet {
    ITable getTable(String entity);
}

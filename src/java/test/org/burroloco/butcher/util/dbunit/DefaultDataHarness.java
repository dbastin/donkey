package org.burroloco.butcher.util.dbunit;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.dataset.csv.CsvDataSet;

import java.io.File;

public class DefaultDataHarness implements DataHarness {
    DatabaseOperator operator;
    Nu nu;

    public void insert(IDatabaseConnection conn, File dataSetDir) {
        CsvDataSet data = data(dataSetDir);
        operator.delete(conn, data);
        operator.insert(conn, data);
    }

    public void update(IDatabaseConnection conn, File dataSetDir) {
        operator.update(conn, data(dataSetDir));
    }

    public void delete(IDatabaseConnection conn, File dataSetDir) {
        operator.delete(conn, data(dataSetDir));
    }

    private CsvDataSet data(File dataSetDir) {
        return nu.nu(CsvDataSet.class, dataSetDir);
    }
}

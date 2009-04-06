package org.burroloco.test.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

import java.io.File;

public interface DataHarness {
    void insert(IDatabaseConnection conn, File dataSetDir);

    void update(IDatabaseConnection conn, File dataSetDir);

    void delete(IDatabaseConnection conn, File dataSetDir);
}

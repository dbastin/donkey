package org.burroloco.donkey.slurp.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultResultSetConverter implements ResultSetConverter {
    RowConverter row;
    Nu nu;

    public Data convert(ResultSet resultSet) {
        Data data = nu.nu(Data.class);
        convert(data, resultSet);
        data.readOnly();
        return data;
    }

    private void convert(Data data, ResultSet resultSet) {
        while (resultSet.next()) {
            Tuple t = row.convert(resultSet);
            data.add(t);
        }
    }
}
package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.cake.Data;

public class DefaultDataHydrater implements DataHydrater {
    TupleHydrater tupleHydrater;
    Nu nu;

    public Data convert(ResultSet resultSet) {
        Data data = nu.nu(Data.class);
        addTuples(data, resultSet);
        data.readOnly();
        return data;
    }

    private void addTuples(Data data, ResultSet resultSet) {
        while (resultSet.next())
            data.add(tupleHydrater.convertRow(resultSet));
    }

}
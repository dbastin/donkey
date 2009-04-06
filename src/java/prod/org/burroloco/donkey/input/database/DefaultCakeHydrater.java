package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.cake.Cake;

public class DefaultCakeHydrater implements CakeHydrater {
    SliceHydrater sliceHydrater;
    Nu nu;

    public Cake convert(ResultSet resultSet) {
        Cake cake = nu.nu(Cake.class);
        addSlices(cake, resultSet);
        cake.refrigerate();
        return cake;
    }

    private void addSlices(Cake cake, ResultSet resultSet) {
        while (resultSet.next())
            cake.add(sliceHydrater.convertRow(resultSet));
    }

}
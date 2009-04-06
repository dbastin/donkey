package org.burroloco.donkey.input.database;

import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.cake.Cake;

public interface CakeHydrater {
    Cake convert(ResultSet resultSet);
}

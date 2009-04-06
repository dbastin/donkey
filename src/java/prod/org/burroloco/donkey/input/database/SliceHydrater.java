package org.burroloco.donkey.input.database;

import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.cake.Slice;

public interface SliceHydrater {
    Slice convertRow(ResultSet resultSet);
}

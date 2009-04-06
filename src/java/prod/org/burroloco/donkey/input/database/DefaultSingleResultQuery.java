package org.burroloco.donkey.input.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.data.error.EmptyCakeException;

import java.util.List;

public class DefaultSingleResultQuery implements SingleResultQuery {
    QueryRunnerEngine engine;

    public Object value(Config config, String sql) {
        Slice slice = slice(config, sql);
        return firstCol(slice);
    }

    public Slice slice(Config config, String sql) {
        Cake cake = tryQuery(config, sql);
        List<Slice> slices = cake.slices();
        return firstSlice(slices);
    }

    private Cake tryQuery(Config config, String sql) {
        try {
            return engine.query(config, sql);
        } catch (EmptyCakeException e) {
            throw new QueryException("Query returned no results: " + sql);
        }
    }

    private Slice firstSlice(List<Slice> slices) {
        if (slices.size() != 1) throw new IllegalArgumentException("Expected exactly 1 slice, got " + slices.size());
        return slices.get(0);
    }

    private Object firstCol(Slice slice) {
        String firstCol = (String) slice.names().toArray()[0];
        return slice.value(firstCol);
    }

}

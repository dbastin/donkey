package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.Sql;
import org.burroloco.donkey.data.error.EmptyCakeException;
import org.burroloco.donkey.input.database.QueryRunnerEngine;
import org.burroloco.donkey.input.database.SqlBuilder;
import org.burroloco.donkey.transformation.error.Puker;
import org.burroloco.donkey.transformation.transform.SliceValueReplacer;

// FIX TSR-DONKEY Use or Lose
public class MultiSliceCakeAugmenter implements CakeAugmenter {
    SliceValueReplacer sliceValueReplacer;
    QueryRunnerEngine engine;
    SqlBuilder builder;
    WeakConfig weak;
    Puker puker;
    Nu nu;

    public Cake augment(Config config, Cake cake, String key) {
        Cake result = nu.nu(Cake.class);
        Config opics = config.flatten("opics");
        for (Slice slice : cake.slices()) {
            multiply(key, result, opics, slice);
        }
        return result;
    }

    private void multiply(String key, Cake result, Config opics, Slice slice) {
        try {
            multiplyAndQuery(result, opics, slice, key);
        } catch (EmptyCakeException e) {
            puker.puke(slice, e);
        }
    }

    private void multiplyAndQuery(Cake result, Config opics, Slice slice, String key) {
        String sql = sql(key, slice, opics);
        Cake extraCake = engine.query(opics, sql);
        for (Slice extra : extraCake.slices()) result.add(join(slice, extra));
    }

    private String sql(String key, Slice slice, Config opics) {
        String sql = builder.build(weak.get(opics, Sql.class));
        return sliceValueReplacer.replace(sql, slice, key);
    }

    private Slice join(Slice slice, Slice extra) {
        Slice fullSlice = nu.nu(Slice.class);
        fullSlice.addAll(slice);
        fullSlice.addAll(extra);
        return fullSlice;
    }

}

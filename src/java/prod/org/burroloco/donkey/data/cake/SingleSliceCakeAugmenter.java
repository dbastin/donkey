package org.burroloco.donkey.data.cake;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.Sql;
import org.burroloco.donkey.input.database.SingleResultQuery;
import org.burroloco.donkey.transformation.transform.SliceValueReplacer;
import org.burroloco.util.string.TokenUtil;

import java.util.List;

// FIX TSR-DONKEY Use or Lose
public class SingleSliceCakeAugmenter implements CakeAugmenter {
    SliceValueReplacer sliceValueReplacer;
    SingleResultQuery query;
    TokenUtil tokens;
    WeakConfig weak;

    public Cake augment(Config config, Cake cake, String key) {
        Config opics = config.flatten("opics");
        List<Slice> slices = cake.slices();
        for (Slice slice : slices) process(opics, slice, key);
        return cake;
    }

    private void process(Config config, Slice slice, String key) {
        String sql = weak.get(config, Sql.class);
        sql = sliceValueReplacer.replace(sql, slice, key);
        Slice extras = query.slice(config, sql);
        slice.addAll(extras);
    }
}

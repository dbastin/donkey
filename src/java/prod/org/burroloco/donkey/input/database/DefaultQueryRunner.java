package org.burroloco.donkey.input.database;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.Sql;
import org.burroloco.donkey.data.cake.Cake;

public class DefaultQueryRunner implements QueryRunner {
    QueryRunnerEngine engine;
    SqlBuilder builder;
    WeakConfig weak;

    public Cake query(Config config) {
        String sqlString = weak.get(config, Sql.class);
        String sql = builder.build(sqlString);
        return engine.query(config, sql);
    }
}
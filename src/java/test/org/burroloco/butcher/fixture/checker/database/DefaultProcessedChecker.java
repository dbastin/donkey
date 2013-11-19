package org.burroloco.butcher.fixture.checker.database;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.util.DataUtil;
import org.burroloco.donkey.slurp.database.QueryRunnerEngine;
import org.junit.Assert;

public class DefaultProcessedChecker implements ProcessedChecker, Constructable {

    private Config config;

    QueryRunnerEngine sql;
    ConfigLoader loader;
    DataUtil data;

    public void constructor() {
        Config c = loader.load("config/common/hsqldb.properties");
        config = c.prefix("db");
    }

    public void check(int count) {
        Data d = sql.query(config, "SELECT COUNT(*) AS PROCESSED FROM PROCESSED");
        Assert.assertEquals(count, processed(d));
    }

    private int processed(Data d) {
        return (Integer) data.singleValue(d);
    }
}

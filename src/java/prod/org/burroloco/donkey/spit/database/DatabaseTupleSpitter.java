package org.burroloco.donkey.spit.database;

import au.net.netstorm.boost.gunge.goop.DefaultNvp;
import au.net.netstorm.boost.gunge.goop.Nvp;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.Configs;
import org.burroloco.donkey.config.Sql;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.spit.core.TupleSpitter;
import org.burroloco.donkey.spit.template.SqlTemplateExpander;

public class DatabaseTupleSpitter implements TupleSpitter {
    SqlTemplateExpander expander;
    Executor runner;
    Configs configs;

    public void spit(Config config, Tuple t) {
        Config c = sql(config, t);
        runner.execute(c);
    }

    private Config sql(Config config, Tuple tuple) {
        String expanded = expander.expand(config, tuple);
        Nvp sql = new DefaultNvp(Sql.NAME, expanded);
        return configs.moosh(config, sql);
    }
}

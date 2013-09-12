package org.burroloco.donkey.output.database;

import au.net.netstorm.boost.gunge.goop.DefaultNvp;
import au.net.netstorm.boost.gunge.goop.Nvp;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.Configs;
import org.burroloco.donkey.config.Sql;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.template.SqlTemplateExpander;

import java.util.List;

public class DatabaseSpitter implements Spitter {
    SqlTemplateExpander expander;
    Executor runner;
    Configs configs;

    public void spit(Config config, Data data) {
        List<Tuple> tuples = data.tuples();
        for (Tuple tuple : tuples) {
            Config c = sql(config, tuple);
            runner.execute(c);
        }
    }

    private Config sql(Config config, Tuple tuple) {
        String expanded = expander.expand(config, tuple);
        Nvp sql = new DefaultNvp(Sql.NAME, expanded);
        return configs.moosh(config, sql);
    }
}

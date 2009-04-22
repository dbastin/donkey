package org.burroloco.donkey.output.database;

import au.net.netstorm.boost.bullet.log.Log;
import edge.java.sql.Connection;
import edge.java.sql.Statement;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.Sql;
import org.burroloco.donkey.input.database.CakeHydrater;
import org.burroloco.donkey.input.database.ConnectionPurveyor;

public class DefaultExecutor implements Executor {
    ConnectionPurveyor purveyor;
    CakeHydrater converter;
    WeakConfig weak;
    Log log;

    public void execute(Config config) {
        Connection connection = purveyor.connection(config);
        Statement statement = connection.createStatement();
        String sql = weak.get(config, Sql.class);
        tryExecute(statement, sql);
    }

    private void tryExecute(Statement statement, String sql) {
        try {
            log.trace("Executing:\n" + sql);
            statement.execute(sql);
        } finally {
            statement.close();
        }
    }
}

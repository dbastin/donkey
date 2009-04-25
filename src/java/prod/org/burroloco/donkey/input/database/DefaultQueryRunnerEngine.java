package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.bullet.log.Log;
import edge.java.sql.Connection;
import edge.java.sql.ResultSet;
import edge.java.sql.Statement;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public class DefaultQueryRunnerEngine implements QueryRunnerEngine {
    ConnectionPurveyor purveyor;
    CakeHydrater converter;
    Log log;

    public Cake query(Config config, String sqlStatement) {
        Connection connection = purveyor.connection(config);
        Statement statement = connection.createStatement();
        return tryExecuteAndConvert(statement, sqlStatement);
    }

    private Cake tryExecuteAndConvert(Statement statement, String sql) {
        try {
            log.trace("Executing: " + sql);
            ResultSet resultSet = statement.executeQuery(sql);
            Cake results = converter.convert(resultSet);
            log.trace(results.slices().size() + " rows returned");
            return results;
        } finally {
            statement.close();
        }
    }
}

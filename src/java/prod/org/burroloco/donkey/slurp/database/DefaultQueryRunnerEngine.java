package org.burroloco.donkey.slurp.database;

import au.net.netstorm.boost.bullet.log.Log;
import edge.java.sql.Connection;
import edge.java.sql.ResultSet;
import edge.java.sql.Statement;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public class DefaultQueryRunnerEngine implements QueryRunnerEngine {
    ConnectionPurveyor purveyor;
    DataHydrater converter;
    Log log;

    public Data query(Config config, String sqlStatement) {
        Connection connection = purveyor.connection(config);
        Statement statement = connection.createStatement();
        return tryExecuteAndConvert(statement, sqlStatement);
    }

    private Data tryExecuteAndConvert(Statement statement, String sql) {
        try {
            log.trace("Executing: " + sql);
            ResultSet resultSet = statement.executeQuery(sql);
            Data results = converter.convert(resultSet);
            log.trace(results.tuples().size() + " rows returned");
            return results;
        } finally {
            statement.close();
        }
    }
}

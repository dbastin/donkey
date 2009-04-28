package org.burroloco.butcher.util.dbunit;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.spider.plugs.provider.core.CleanProvider;
import edge.org.dbunit.IDatabaseTester;
import edge.org.dbunit.database.IDatabaseConnection;
import org.dbunit.JdbcDatabaseTester;

public class IDatabaseConnectionProvider extends CleanProvider {
    Edges edger;

    public Object nu(Object... args) {
        return getNewConnection((String)args[0], (String)args[1], (String)args[2], (String)args[3]);
    }

    private IDatabaseConnection getNewConnection(String url, String user, String password, String driver) {
        JdbcDatabaseTester real = new JdbcDatabaseTester(driver, url, user, password);
        IDatabaseTester database = edger.edge(IDatabaseTester.class, real);
        return database.getConnection();
    }
}

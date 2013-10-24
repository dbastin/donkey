package org.burroloco.donkey.slurp.database;

import au.net.netstorm.boost.spider.plugs.provider.core.CleanProvider;
import edge.java.lang.ClassStatic;
import edge.java.sql.Connection;
import edge.java.sql.DriverManagerStatic;

public class DatabaseConnectionProvider extends CleanProvider {
    DriverManagerStatic manager;
    ClassStatic classer;

    public Object nu(Object... args) {
        return getNewConnection((String) args[0], (String) args[1], (String) args[2], (String) args[3]);
    }

    private Connection getNewConnection(String url, String user, String password, String driver) {
        classer.forName(driver);
        return manager.getConnection(url, user, password);
    }
}
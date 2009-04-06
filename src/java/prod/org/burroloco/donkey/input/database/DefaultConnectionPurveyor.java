package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.Connection;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.DatabaseDriver;
import org.burroloco.donkey.config.DatabasePassword;
import org.burroloco.donkey.config.DatabaseUrl;
import org.burroloco.donkey.config.DatabaseUser;

public class DefaultConnectionPurveyor implements ConnectionPurveyor {
    Weaken weaken;
    Nu nu;

    public Connection connection(Config config) {
        DatabaseUrl url = config.get(DatabaseUrl.class);
        DatabaseDriver driver = config.get(DatabaseDriver.class);
        DatabaseUser user = config.get(DatabaseUser.class);
        DatabasePassword password = config.get(DatabasePassword.class);
        return nu.nu(Connection.class, weaken.w(url), weaken.w(user), weaken.w(password), weaken.w(driver));
    }
}

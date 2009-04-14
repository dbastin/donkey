package org.burroloco.test.util.dbunit;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.dbunit.database.IDatabaseConnection;
import org.burroloco.test.constants.DbTestConstants;
import org.burroloco.test.glue.env.DbParameters;

// FIX TSR-DONKEY Clean this up.
public class DefaultDatabase implements Database, DbTestConstants {
    DbParameters db;
    Nu nu;

    public IDatabaseConnection opics() {
        return nu.nu(DATABASE_CLS, db.opics(), OPICS_USER, OPICS_PASSWORD, ORACLE_DRIVER);
    }

    public IDatabaseConnection kplusLocal() {
        return nu.nu(DATABASE_CLS, db.kplus(), KPLUS_USER, KPLUS_PASSWORD, SYBASE_DRIVER);
    }

    public IDatabaseConnection kplusTP() {
        return nu.nu(DATABASE_CLS, db.kplustp(), KPLUS_USER, KPLUS_PASSWORD, SYBASE_DRIVER);
    }

    public IDatabaseConnection kustom() {
        return nu.nu(DATABASE_CLS, db.kustom(), KPLUS_USER, KPLUS_PASSWORD, SYBASE_DRIVER);
    }

    public IDatabaseConnection hsqldb() {
        return nu.nu(DATABASE_CLS, "jdbc:hsqldb:mem:employee", "sa", "", "org.hsqldb.jdbcDriver");
    }
}

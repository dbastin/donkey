package org.burroloco.test.constants;

import edge.org.dbunit.database.IDatabaseConnection;


public interface DbTestConstants extends TestConstants {
    Class<IDatabaseConnection> DATABASE_CLS = IDatabaseConnection.class;
    String SYBASE_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
    String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    String OPICS_DB_URL = "jdbc:oracle:thin:@trmtest:1521:DEV4OPCS";
    String KPLUS_USER = "kplus";
    String KPLUS_PASSWORD = "Orange01";
    String OPICS_USER = "opicsro";
    String OPICS_PASSWORD = "ankle";
    String SQL_TOKEN = "@PROD_SQL@";
    String ISQL_KPLUS_LOGIN = "-U" + KPLUS_USER + " -P" + KPLUS_PASSWORD;
}

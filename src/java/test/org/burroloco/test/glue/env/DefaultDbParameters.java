package org.burroloco.test.glue.env;

import org.burroloco.test.constants.DbTestConstants;

public class DefaultDbParameters implements DbParameters, DbTestConstants {
    private final String host;
    private final String dbPort;

    public DefaultDbParameters(String host, String dbPort) {
        this.host = host;
        this.dbPort = dbPort;
    }

    public String opics() {
        return OPICS_DB_URL;
    }

    public String kplus() {
        return buildSybaseUrl(host, dbPort, "KplusLocal");
    }

    public String kplustp() {
        return buildSybaseUrl(host, dbPort, "KplusTP");
    }

    public String kustom() {
        return buildSybaseUrl(host, dbPort, "Kustom");
    }
    
    private String buildSybaseUrl(String host, String port, String dbName) {
        return "jdbc:jtds:sybase://" + host + ":" + port + "/" + dbName;
    }
}

package org.burroloco.shed.utils.ssh;

public class DefaultSshContext implements SshContext {
    private final String user;
    private final String pass;
    private final String host;
    private final int timeout = 40;

    public DefaultSshContext(String user, String pass, String host) {
        this.user = user;
        this.pass = pass;
        this.host = host;
    }

    public String getUsername() {
        return user;
    }

    public String getPassword() {
        return pass;
    }

    public String getHost() {
        return host;
    }

    public int getTimeout() {
        return timeout;
    }
}

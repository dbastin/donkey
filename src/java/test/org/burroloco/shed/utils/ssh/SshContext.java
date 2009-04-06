package org.burroloco.shed.utils.ssh;

public interface SshContext {
    String getUsername();
    String getPassword();
    String getHost();
    int getTimeout();
}

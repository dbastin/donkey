package org.burroloco.shed.utils.ssh;

public interface SshOk {
    boolean exec(SshContext context, String command, long timeoutSecs);
}

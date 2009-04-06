package org.burroloco.shed.utils.ssh;

public interface Ssh {
    String exec(SshContext context, String command, long timeoutSecs, boolean failOnError);
}

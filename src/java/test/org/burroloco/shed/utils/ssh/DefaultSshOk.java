package org.burroloco.shed.utils.ssh;

public class DefaultSshOk implements SshOk {
    Ssh ssh;
    
    public boolean exec(SshContext context, String command, long timeoutSecs) {
        try {
            ssh.exec(context, command, timeoutSecs, true);
            return true;
        } catch (Throwable t) {
            return false;
        }
    }
}

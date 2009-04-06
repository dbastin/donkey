package org.burroloco.shed.api.log;

import org.burroloco.shed.internals.SshContextFactory;
import org.burroloco.shed.model.Environment;
import org.burroloco.shed.utils.ssh.Ssh;
import org.burroloco.shed.utils.ssh.SshContext;

public class DefaultLogs implements Logs {
    private static final String START_LOG = "log/control_kondor_%d_start.log";
    private static final String SHUTDOWN_LOG = "log/control_kondor_%d_shutdown.log";
    private static final String REFRESH_LOG = "log/refresh_%d*.log";
    private static final String LIST = "ls -1 ";
    SshContextFactory context;
    Ssh ssh;

    public String[] start(Environment env) {
        return log(env, command(env, START_LOG));
    }

    public String[] shutdown(Environment env) {
        return log(env, command(env, SHUTDOWN_LOG));
    }

    public String[] refresh(Environment env) {
        return log(env, command(env, REFRESH_LOG));
    }

    private String[] log(Environment env, String command) {
        SshContext reuters = context.reuters(env);
        String output = ssh.exec(reuters, command, 60, true);
        return output.split("\n");
    }

    private String command(Environment env, String log) {
        return LIST + String.format(log, env.number());
    }
}

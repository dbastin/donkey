package org.burroloco.shed.utils.ssh;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.ssh.SSHExec;

public class DefaultSsh implements Ssh {
    private static final String SSH_OUTPUT = "ssh.output";
    private static final long ONE_SECOND = 1000;

    public String exec(SshContext context, String sshCommand, long timeoutSecs, boolean failOnError) {
        SSHExec ssh = createSsh(context);
        return execute(ssh, timeoutSecs * ONE_SECOND, sshCommand, failOnError);
    }

    private SSHExec createSsh(SshContext context) {
        SSHExec ssh = create();
        setContext(context,  ssh);
        ssh.setOutputproperty(SSH_OUTPUT);
        return ssh;
    }

    private SSHExec create() {
        SSHExec ssh = new SSHExec();
        ssh.init();
        ssh.setProject(new Project());
        return ssh;
    }

    private void setContext(SshContext context, SSHExec ssh) {
        ssh.setHost(context.getHost());
        ssh.setUsername(context.getUsername());
        ssh.setPassword(context.getPassword());
    }

    private String execute(SSHExec ssh, long timeout, String sshCommand, boolean failOnError) {
        ssh.setCommand(sshCommand);
        ssh.setTimeout(timeout);
        ssh.setTrust(true);
        ssh.setFailonerror(failOnError);
        ssh.execute();
        return ssh.getProject().getProperty(SSH_OUTPUT);
    }
}
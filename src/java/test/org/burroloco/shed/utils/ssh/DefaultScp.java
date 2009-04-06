package org.burroloco.shed.utils.ssh;

import au.net.netstorm.boost.bullet.log.Log;
import org.apache.tools.ant.Project;

import java.io.File;

public class DefaultScp implements Scp {
    Log log;

    public void copyFromHost(SshContext context, String source, File target) {
        org.apache.tools.ant.taskdefs.optional.ssh.Scp scp = create();
        scp.setRemoteFile(remote(context, source));
        scp.setLocalTodir(target.getAbsolutePath());
        log.trace("Copying " + source + " to " + target);
        copy(scp);
    }

    public void copyToHost(SshContext context, File source, String target) {
        org.apache.tools.ant.taskdefs.optional.ssh.Scp scp = create();
        scp.setLocalFile(source.getAbsolutePath());
        String scpRemote = remote(context, target);
        scp.setRemoteTodir(scpRemote);
        log.trace("Copying " + source + " to " + target);
        copy(scp);
    }

    private org.apache.tools.ant.taskdefs.optional.ssh.Scp create() {
        org.apache.tools.ant.taskdefs.optional.ssh.Scp scp = new org.apache.tools.ant.taskdefs.optional.ssh.Scp();
        scp.init();
        scp.setProject(new Project());
        return scp;
    }

    private String remote(SshContext context, String remoteDirPath) {
        return context.getUsername() + ":" + context.getPassword() + "@" + context.getHost() + ":" + remoteDirPath;
    }

    private void copy(org.apache.tools.ant.taskdefs.optional.ssh.Scp scp) {
        scp.setTrust(true);
        scp.execute();
    }
}

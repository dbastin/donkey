package org.burroloco.shed.utils.ssh;

import java.io.File;

public interface Scp {
    void copyFromHost(SshContext context, String remoteFilePath, File localDir);

    void copyToHost(SshContext context, File localFile, String remoteDirPath);
}

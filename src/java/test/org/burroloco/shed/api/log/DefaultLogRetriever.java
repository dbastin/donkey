package org.burroloco.shed.api.log;

import org.burroloco.shed.internals.SshContextFactory;
import org.burroloco.shed.model.Environment;
import org.burroloco.shed.utils.ssh.Ssh;

public class DefaultLogRetriever implements LogRetriever {
    SshContextFactory context;
    Ssh ssh;

    public String retrieve(Environment env, String filename) {
        return ssh.exec(context.reuters(env), "cat log/" + filename, 60, true);
    }
}

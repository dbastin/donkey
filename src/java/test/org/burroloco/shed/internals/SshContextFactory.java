package org.burroloco.shed.internals;

import org.burroloco.shed.model.Environment;
import org.burroloco.shed.utils.ssh.SshContext;

public interface SshContextFactory {
    SshContext reuters(Environment environment);
    SshContext kplus(Environment environment);
    SshContext kplustp(Environment environment);
}

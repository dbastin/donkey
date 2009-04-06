package org.burroloco.shed.internals;

import org.burroloco.shed.model.Environment;
import org.burroloco.shed.utils.ssh.DefaultSshContext;
import org.burroloco.shed.utils.ssh.SshContext;

public class DefaultSshContextFactory implements SshContextFactory {
    private static final String PASSWORD = "cft6CFT^";

    public SshContext reuters(Environment environment) {
        return new DefaultSshContext("reuters", PASSWORD, environment.host());
    }

    public SshContext kplus(Environment environment) {
        return new DefaultSshContext("kplus" + environment.number(), PASSWORD, environment.host());
    }

    public SshContext kplustp(Environment environment) {
        return new DefaultSshContext("kplustp" + environment.number(), PASSWORD, environment.host());
    }
}

package org.burroloco.util.wire;

import au.net.netstorm.boost.spider.api.config.wire.Wire;

public class DefaultDna implements Dna {
    Wire wire;
    
    public <T> void strand(Class<T> iface, Class<? extends T>... impls) {
        head(iface, impls);
        for (int i = 1; i < impls.length; ++i) seq(iface, impls[i - 1], impls[i]);    
    }

    private <T> void head(Class<T> iface, Class<? extends T>... impls) {
        wire.cls(impls[0]).to(iface);
    }

    private <T> void seq(Class<T> iface, Class<? extends T> host, Class<? extends T> impl) {
        wire.cls(impl).to(iface, host);
    }
}

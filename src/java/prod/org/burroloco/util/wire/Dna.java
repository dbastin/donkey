package org.burroloco.util.wire;

public interface Dna {
    <T> void strand(Class<T> iface, Class<? extends T>... impls);
}

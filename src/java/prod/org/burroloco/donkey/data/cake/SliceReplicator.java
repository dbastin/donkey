package org.burroloco.donkey.data.cake;

public interface SliceReplicator {
    Slice clone(Slice original, Slice changes);
}

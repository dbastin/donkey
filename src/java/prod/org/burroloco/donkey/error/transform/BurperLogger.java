package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.cake.Slice;

public interface BurperLogger {
    void log(Slice s, Exception e);
}

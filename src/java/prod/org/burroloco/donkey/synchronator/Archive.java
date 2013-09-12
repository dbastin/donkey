package org.burroloco.donkey.synchronator;

import org.burroloco.donkey.data.core.Data;

public interface Archive {
    Data get(String name);
}

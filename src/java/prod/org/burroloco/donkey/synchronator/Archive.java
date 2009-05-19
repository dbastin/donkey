package org.burroloco.donkey.synchronator;

import org.burroloco.donkey.data.cake.Cake;

public interface Archive {
    Cake get(String name);
}

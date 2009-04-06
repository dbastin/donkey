package org.burroloco.donkey.data.cake;

import java.util.List;

public interface Striper {
    List<Slice> stripe(Cake c, String... names);
}

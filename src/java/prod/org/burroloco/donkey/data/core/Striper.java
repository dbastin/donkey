package org.burroloco.donkey.data.core;

import java.util.List;

public interface Striper {
    List<Tuple> stripe(Data c, String... names);
}

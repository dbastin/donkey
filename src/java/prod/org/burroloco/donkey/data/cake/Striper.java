package org.burroloco.donkey.data.cake;

import java.util.List;

public interface Striper {
    List<Tuple> stripe(Data c, String... names);
}

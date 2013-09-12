package org.burroloco.donkey.data.core;

import java.util.List;

public interface Stripes {
    List<Tuple> minus(Data c1, Data c2, String... keys);

    List<Tuple> same(Data c1, Data c2, String... keys);
}

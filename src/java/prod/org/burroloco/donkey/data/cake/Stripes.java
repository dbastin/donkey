package org.burroloco.donkey.data.cake;

import java.util.List;

public interface Stripes {
    List<Slice> minus(Cake c1, Cake c2, String... keys);

    List<Slice> same(Cake c1, Cake c2, String... keys);
}

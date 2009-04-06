package org.burroloco.donkey.data.cake;

public interface Patissier {
    Cake same(Cake c1, Cake c2);

    Cake minus(Cake c1, Cake c2, String... keys);

    Cake changes(Cake c1, Cake c2, String... keys);
}

package org.burroloco.donkey.data.cake;

public interface Patissier {
    Data same(Data c1, Data c2);

    Data minus(Data c1, Data c2, String... keys);

    Data changes(Data c1, Data c2, String... keys);
}

package org.burroloco.donkey.data.cake;

public interface TolerantBaker {
    Cake clone(Cake cake, String... ignores);
}

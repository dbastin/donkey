package org.burroloco.donkey.data.core;

public interface DataMaster {
    Data intersection(Data c1, Data c2);

    Data minus(Data c1, Data c2, String... keys);

    Data diffs(Data c1, Data c2, String... keys);
}

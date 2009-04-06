package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.data.cake.Cake;

public interface WeakCsvSlurper {
    Cake slurp(String filename);
}

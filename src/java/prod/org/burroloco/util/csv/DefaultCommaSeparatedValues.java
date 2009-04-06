package org.burroloco.util.csv;

import java.util.Arrays;
import java.util.List;

public class DefaultCommaSeparatedValues implements CommaSeparatedValues {
    public List<String> list(String list) {
        String[] elements = list.split(",");
        return Arrays.asList(elements);
    }
}

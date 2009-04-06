package org.burroloco.test.util.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefaultLineSorter implements LineSorter {
    public String sort(String s) {
        String[] strings = s.split("\n");
        List<String> list = Arrays.asList(strings);
        Collections.sort(list);
        StringBuilder result = new StringBuilder();
        for (String line : list) result.append(line);
        return result.toString();
    }
}

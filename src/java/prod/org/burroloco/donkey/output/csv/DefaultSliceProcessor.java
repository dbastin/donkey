package org.burroloco.donkey.output.csv;

import java.util.Collection;

public class DefaultSliceProcessor implements SliceProcessor {
    ValueProcessor valueProcessor;

        public void values(StringBuilder results, Collection values) {
        Object[] objects = values.toArray();
        for (int i = 0; i < objects.length; i++) {
            if (i > 0) results.append(",");
            Object value = objects[i];
            results.append(valueProcessor.string(value));
        }
    }
}

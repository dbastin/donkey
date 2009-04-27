package org.burroloco.donkey.output.csv;

public class DefaultValueProcessor implements ValueProcessor {
    public String string(Object value) {
        return '"' + value.toString() + '"';
    }

}

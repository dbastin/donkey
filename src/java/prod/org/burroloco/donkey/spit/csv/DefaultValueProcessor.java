package org.burroloco.donkey.spit.csv;

public class DefaultValueProcessor implements ValueProcessor {
    public String string(Object value) {
        return '"' + value.toString() + '"';
    }

}

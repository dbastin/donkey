package org.burroloco.util.string;

public class DefaultStringTruncate implements StringTruncate {
    public String truncate(String s, int max) {
        return s.length() > max ? s.substring(0, max) : s;
    }
}

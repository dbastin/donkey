package org.burroloco.util.string;

// FIX TSR-DONKEY Use or Lose
public class DefaultStringTruncate implements StringTruncate {
    public String truncate(String s, int max) {
        return s.length() > max ? s.substring(0, max) : s;
    }
}

package org.burroloco.util.string;

// FIX TSR-DONKEY Use or Lose
public class DefaultTail implements Tail {
    public String strip(String s, String tail) {
        return s.replaceAll(tail + "\\z", "");
    }
}

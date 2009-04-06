package org.burroloco.util.string;

public class DefaultTail implements Tail {
    public String strip(String s, String tail) {
        return s.replaceAll(tail + "\\z", "");
    }
}

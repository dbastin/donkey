package org.burroloco.test.butcher.util.string;

public class DefaultStripper implements Stripper {
    public String strip(String target, String regex) {
        return target.replaceAll(regex, "");
    }
}

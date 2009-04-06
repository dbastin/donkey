package org.burroloco.util.string;

public class DefaultFiller implements Filler {
    public String fill(String s, int width) {
        String result = s;
        while (result.length() < width) result += " ";
        return result;
    }
}

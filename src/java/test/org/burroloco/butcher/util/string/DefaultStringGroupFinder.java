package org.burroloco.butcher.util.string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultStringGroupFinder implements StringGroupFinder {
    public List<String> find(String s, Pattern pattern, int groupNumber) {
        List<String> groups = new ArrayList<String>();
        Matcher m = pattern.matcher(s);
        while (m.find()) groups.add(m.group(groupNumber));
        return groups;
    }

}

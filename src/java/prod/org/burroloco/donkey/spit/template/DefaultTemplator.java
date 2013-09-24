package org.burroloco.donkey.spit.template;

import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.data.core.Slicer;
import org.burroloco.util.string.TokenUtil;

import java.util.Map;

public class DefaultTemplator implements Templator {
    TokenUtil tokenUtil;
    Slicer slicer;

    public String apply(Tuple tuple, String template) {
        Map<String, String> map = slicer.stringMap(tuple);
        return tokenUtil.replace(template, map);
    }
}

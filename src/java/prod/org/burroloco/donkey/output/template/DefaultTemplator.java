package org.burroloco.donkey.output.template;

import org.burroloco.donkey.data.cake.Tuple;
import org.burroloco.donkey.data.cake.Slicer;
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

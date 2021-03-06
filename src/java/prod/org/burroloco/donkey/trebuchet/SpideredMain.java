package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.entry.Go;
import edge.java.lang.ClassStatic;

public class SpideredMain implements Go {
    private static final String USAGE = "usage: " + Main.class.getName() + " specificationClass";
    Trebuchet trebuchet;
    ClassStatic classer;


    public void go(String[] args) {
        if (args.length != 1) throw new IllegalArgumentException(USAGE);
        Class specCls = classer.forName(args[0]);
        trebuchet.launch(specCls);
    }
}

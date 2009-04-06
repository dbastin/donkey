package org.burroloco.shed.model;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefaultEnvironments implements Environments, Constructable {
    private Map<String, Environment> envs = new LinkedHashMap<String, Environment>();
    Nu nu;

    // OK NCSS {
    public void constructor() {
        add("chef",    "konst1", 1);
        add("kermit",  "konst1", 2);
        add("george",  "konst1", 3);
        add("sam",     "konst1", 4);
        add("statler", "konst1", 5);
        add("beaker",  "konst1", 6);
        add("janice",  "konst1", 7);
        add("waldorf", "konst1", 8);
        add("rizzo",   "konsd1", 1);
        add("floyd",   "konsd1", 2);
        add("julius",  "konsd2", 3);
        add("marvin",  "konsd2", 4);
        add("harry",   "konsd3", 5);
        add("scooter", "konsd3", 6);
    }
    // } NCSS

    public Environment get(String muppet) {
        if (!envs.containsKey(muppet)) throw new IllegalArgumentException("Invalid muppet: " + muppet);
        return envs.get(muppet);
    }

    public List<Environment> all() {
        return new ArrayList<Environment>(envs.values());
    }

    private void add(String name, String host, int number) {
        Environment env = nu.nu(Environment.class, name, host, number);
        envs.put(name, env);
    }

}

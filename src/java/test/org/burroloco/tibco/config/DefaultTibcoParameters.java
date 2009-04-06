package org.burroloco.tibco.config;


public class DefaultTibcoParameters implements TibcoParameters {

    public String service() {
        return "7" + n() + n() + n();
    }

    public String network() {
        if (konst1()) return tangoNetwork();
        return deltaNetwork();
    }

    public String daemon() {
        return "tcp:" + h() + ":7" + n() + "00";
    }

    private String tangoNetwork() {
        String s = "." + n();
        return "bge0:2;224" + s + s + s;
    }

    private String deltaNetwork() {
        String s = ".1" + n();
        return "e1000g0;224" + s + s + s;
    }

    private boolean konst1() {
        return h().contains("konst1");
    }

    // FIX DONKEY Fix...
    private String h() {
        return "konst1";
    }

    // FIX DONKEY Fix...
    private String n() {
        return "6";
    }
}

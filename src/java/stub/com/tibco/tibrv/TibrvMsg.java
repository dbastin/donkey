package com.tibco.tibrv;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public class TibrvMsg extends Primordial {
    public static final short STRING = 1;
    public static final short I32 = 2;
    private String subject;
    private String key;
    private Object value;

    public void setSendSubject(String subject) {
        this.subject = subject;
    }

    public String getSendSubject() {
        return subject;
    }

    public void add(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}

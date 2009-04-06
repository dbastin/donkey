package org.burroloco.test.glue.env;

public class DefaultLocalParameters implements LocalParameters {
    private String mnemonic;

    public DefaultLocalParameters(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String mnemonic() {
        return mnemonic;
    }
}

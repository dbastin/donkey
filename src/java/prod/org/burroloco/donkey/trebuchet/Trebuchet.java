package org.burroloco.donkey.trebuchet;

public interface Trebuchet {
    void launch(Class<? extends Payload> sling);
}

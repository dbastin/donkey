package org.burroloco.donkey.web;

import au.net.netstorm.boost.bullet.log.Log;

import java.io.File;

public class DefaultExtraScoper implements ExtraScoper {
    ExtraScoperEngine engine;
    Log log;

    public void scope(String fileName) {
        if (!hasExtras(fileName)) log(fileName);
        else engine.scope(fileName);
    }

    private boolean hasExtras(String extras) {
        return new File(extras).exists();
    }

    private void log(String fileName) {
        log.info("No file: " + fileName + " containing extra injection scopes was found.");
    }
}

package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.gunge.lifecycle.Start;

// FIX TSR-DONKEY Use or lose.
public class StartRunnable implements Runnable {
    Start start;

    public StartRunnable(Start start) {
        this.start = start;
    }

    public void run() {
        start.start();
    }
}

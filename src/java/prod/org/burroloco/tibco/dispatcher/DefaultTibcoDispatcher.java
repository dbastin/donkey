package org.burroloco.tibco.dispatcher;

import edge.com.tibco.tibrv.TibrvDispatcher;

public class DefaultTibcoDispatcher implements TibcoDispatcher {
    private final TibrvDispatcher dispatcher;

    protected DefaultTibcoDispatcher(TibrvDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void join() {
        dispatcher.join();
    }
}

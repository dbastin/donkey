package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.bullet.farmer.Push;

public class SplittingPush<T> implements Push<T> {
    Push push;

    public void starting() {
        throw new UnsupportedOperationException();
    }

    public void push(T t) {
        Iterable items = (Iterable) t;
        for (Object obj : items) {
            push.push(obj);
        }
    }

    public void fail(Throwable t) {
        throw new UnsupportedOperationException();
    }

}

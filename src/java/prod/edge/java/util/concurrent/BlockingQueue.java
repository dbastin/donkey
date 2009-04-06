package edge.java.util.concurrent;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.util.concurrent.TimeUnit;

public interface BlockingQueue<T> extends Edge {
    boolean offer(T t);

    T poll(long i, TimeUnit seconds);
}

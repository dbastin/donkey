package edge.org.slf4j;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface Logger extends Edge {
    void trace(String s, Throwable t);

    void info(String s, Throwable t);

    void warn(String s, Throwable t);

    void error(String s, Throwable t);

    boolean isTraceEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    boolean isErrorEnabled();

    void trace(String s);
}

package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.LogEngine;
import au.net.netstorm.boost.bullet.log.LogLevel;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import edge.org.slf4j.Logger;
import edge.org.slf4j.LoggerFactoryStatic;

public final class Slf4jLogEngine implements LogEngine, Constructable {
    private static final LogLevel TRACE = LogLevel.TRACE;
    private static final LogLevel INFO = LogLevel.INFO;
    private static final LogLevel WARN = LogLevel.WARN;
    private static final LogLevel ERROR = LogLevel.ERROR;
    private static final String NO_LOG_MESSAGE = "NO LOG MESSAGE";
    private final Class cls;
    private Logger logger;
    LoggerFactoryStatic loggerFactory;

    public Slf4jLogEngine(Class cls) {
        this.cls = cls;
    }

    public void constructor() {
        logger = loggerFactory.getLogger(cls);
    }

    public void log(LogLevel level, Object o) {
        log(level, o, null);
    }

    public void log(LogLevel level, Throwable t) {
        log(level, NO_LOG_MESSAGE, t);
    }

    // OK CyclomaticComplexity {
    public void log(LogLevel level, Object o, Throwable t) {
        if (is(level, TRACE)) logger.trace(o.toString(), t);
        if (is(level, INFO)) logger.info(o.toString(), t);
        if (is(level, WARN)) logger.warn(o.toString(), t);
        if (is(level, ERROR)) logger.error(o.toString(), t);
    }
    // } OK CyclomaticComplexity

    private boolean is(LogLevel level, LogLevel expected) {
        return level.equals(expected);
    }
}

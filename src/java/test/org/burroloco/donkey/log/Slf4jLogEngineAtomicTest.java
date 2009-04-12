package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.LogEngine;
import au.net.netstorm.boost.bullet.log.LogLevel;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import edge.org.slf4j.Logger;
import edge.org.slf4j.LoggerFactoryStatic;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

import java.util.Random;

public final class Slf4jLogEngineAtomicTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private static final LogLevel TRACE = LogLevel.TRACE;
    private static final LogLevel INFO = LogLevel.INFO;
    private static final LogLevel WARN = LogLevel.WARN;
    private static final LogLevel ERROR = LogLevel.ERROR;
    private static final String NO_LOG_MESSAGE = "NO LOG MESSAGE";
    private LogEngine subject;
    LoggerFactoryStatic loggerFactoryMock;
    Throwable throwableDummy;
    Logger loggerMock;
    Resolver resolver;
    Object objDummy;
    Impl impl;

    public void fixtures() {
        expect.oneCall(loggerFactoryMock, loggerMock, "getLogger", Random.class);
        LoggerFactoryStatic current = resolver.resolve(LoggerFactoryStatic.class);
        wire.ref(loggerFactoryMock).to(LoggerFactoryStatic.class);
        subject = impl.impl(Slf4jLogEngine.class, Random.class);
        wire.ref(current).to(LoggerFactoryStatic.class);
    }

    public void testLogWithObjAndThrowable() {
        logWithObjAndThrowable("trace", objDummy.toString(), TRACE);
        logWithObjAndThrowable("info", objDummy.toString(), INFO);
        logWithObjAndThrowable("error", objDummy.toString(), ERROR);
        logWithObjAndThrowable("warn", objDummy.toString(), WARN);
    }

    public void testLogWithObj() {
        logWithObj("trace", TRACE);
        logWithObj("info", INFO);
        logWithObj("error", ERROR);
        logWithObj("warn", WARN);
    }

    public void testLogWithThrowable() {
        logWithThrowable("trace", TRACE);
        logWithThrowable("info", INFO);
        logWithThrowable("error", ERROR);
        logWithThrowable("warn", WARN);
    }

    private void logWithObjAndThrowable(String logMethod, String msg, LogLevel logLevel) {
        expect(logMethod, msg, throwableDummy);
        subject.log(logLevel, objDummy, throwableDummy);
    }

    private void logWithObj(String logMethod, LogLevel logLevel) {
        expect(logMethod, objDummy.toString(), null);
        subject.log(logLevel, objDummy);
    }

    private void logWithThrowable(String logMethod, LogLevel logLevel) {
        expect(logMethod, NO_LOG_MESSAGE, throwableDummy);
        subject.log(logLevel, throwableDummy);
    }

    private void expect(String logMethod, String msg, Throwable t) {
        expect.oneCall(loggerMock, VOID, logMethod, msg, t);
    }

}

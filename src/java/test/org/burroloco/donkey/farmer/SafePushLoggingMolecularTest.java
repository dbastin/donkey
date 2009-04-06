package org.burroloco.donkey.farmer;

import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.log.LogCleaner;
import org.burroloco.test.butcher.fixture.checker.file.PollingFileChecker;
import org.burroloco.test.constants.TestConstants;
import org.burroloco.test.glue.testcase.TsrTestCase;
import org.burroloco.test.util.io.FileWirer;

public class SafePushLoggingMolecularTest extends TsrTestCase implements HasFixtures, TestConstants, LazyFields {
    private static final String NOT_A_FILE = "xxx";
    private SafePush subject;
    PollingFileChecker filePoller;
    LogCleaner logCleaner;
    Config configDummy;
    FileWirer file;
    Impl impl;

    public void fixtures() {
        logCleaner.clean();
        wire.impl(SingleFilePush.class, configDummy).to(Push.class, SafePush.class);
        subject = impl.impl(SafePush.class);
    }

    public void testLogAndSwallow() {
        subject.push(NOT_A_FILE);
        filePoller.check(file.file(LOG), "ClassCastException: " + NOT_A_FILE.getClass().getName());
    }
}

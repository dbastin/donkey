package org.burroloco.donkey.web;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import org.burroloco.butcher.fixture.checker.file.FileChecker;
import org.burroloco.butcher.util.file.FileCleaner;
import static org.burroloco.donkey.glue.constants.DonkeyTestConstants.LOG;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.thirdparty.scope.test.FredString;

public class DefaultExtraScoperAtomicTest extends DonkeyTestCase implements HasFixtures {
    FileChecker checker;
    FileCleaner cleaner;

    public void fixtures() {
        cleaner.clean(LOG);
    }

    public void testExtras() {
        Spider spider = spider();
        FredString fredString = spider.nu(FredString.class);
        assertEquals("fred", fredString.externalize());
    }

    public void testExtrasFileDoesNotExist() {
        ExtraScoper scoper = spider.resolve(ExtraScoper.class);
        scoper.scope("no.file");
    }

    private Spider spider() {
        Egg egg = new SpiderEgg(BoostWeb.class, ExtraScoperWeb.class);
        return egg.hatch();
    }
}

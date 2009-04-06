package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.entry.SpiderMain;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import org.burroloco.donkey.web.DonkeyWeb;

public class Main {
    public static void main(String... args) {
        au.net.netstorm.boost.spider.api.entry.Main entry = new SpiderMain(BoostWeb.class, DonkeyWeb.class);
        entry.main(SpideredMain.class, args);
    }
}

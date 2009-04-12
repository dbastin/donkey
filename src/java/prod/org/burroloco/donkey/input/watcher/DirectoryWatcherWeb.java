package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.bullet.farmer.Continuer;
import au.net.netstorm.boost.bullet.farmer.DefaultContinuer;
import au.net.netstorm.boost.bullet.farmer.DefaultFarmerFu;
import au.net.netstorm.boost.bullet.farmer.FarmerFu;
import au.net.netstorm.boost.bullet.farmer.FarmerStartStop;
import au.net.netstorm.boost.bullet.farmer.PollingFarmerFu;
import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.gunge.lifecycle.StartStop;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.donkey.farmer.SafePush;
import org.burroloco.donkey.input.file.InputFileNameProvider;
import org.burroloco.donkey.input.file.ReferenceInputFileNameProvider;
import org.burroloco.util.wire.Dna;

public class DirectoryWatcherWeb implements Web {
    Wire wire;
    Dna dna;

    public void web() {
        dna.strand(FarmerFu.class, PollingFarmerFu.class, DefaultFarmerFu.class);
        dna.strand(Push.class, SplittingPush.class, SafePush.class);
        wire.cls(FarmerStartStop.class).to(StartStop.class);
        wire.cls(DefaultContinuer.class).one().to(Continuer.class);
        wire.cls(ReferenceInputFileNameProvider.class).to(InputFileNameProvider.class);
    }

}

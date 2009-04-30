package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.HttpRequest;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

import java.util.Date;

public class DefaultHttpSlurper implements HttpSlurper {
    Weaken weaken;
    Nu nu;

    public Cake slurp(Config config) {
        HttpRequest httpRequest = config.get(HttpRequest.class);
        Cake out = nu.nu(Cake.class);
        Slice slice = nu.nu(Slice.class);
        slice.add("Message", weaken.w(httpRequest));
        // OK IllegalRegexp {
        slice.add("Date", new Date());
        // }
        out.add(slice);
        return out;
    }
}

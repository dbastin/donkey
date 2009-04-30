package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.HttpRequest;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.util.date.Dates;

public class DefaultHttpSlurper implements HttpSlurper {
    Weaken weaken;
    Dates dates;
    Nu nu;

    public Cake slurp(Config config) {
        HttpRequest httpRequest = config.get(HttpRequest.class);
        Cake out = nu.nu(Cake.class);
        out.add(slice(httpRequest));
        return out;
    }

    private Slice slice(HttpRequest httpRequest) {
        Slice slice = nu.nu(Slice.class);
        slice.add("Message", weaken.w(httpRequest));
        slice.add("Date", dates.now());
        return slice;
    }
}

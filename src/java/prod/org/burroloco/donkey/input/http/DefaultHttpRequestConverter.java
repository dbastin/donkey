package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.config.HttpMessage;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.util.date.Dates;

public class DefaultHttpRequestConverter implements HttpRequestConverter {
    Weaken weaken;
    Dates dates;
    Nu nu;

    public Cake convert(HttpMessage message) {
        Cake out = nu.nu(Cake.class);
        out.add(slice(message));
        return out;
    }

    private Slice slice(HttpMessage message) {
        Slice slice = nu.nu(Slice.class);
        slice.add("Message", weaken.w(message));
        slice.add("Date", dates.now());
        return slice;
    }
}

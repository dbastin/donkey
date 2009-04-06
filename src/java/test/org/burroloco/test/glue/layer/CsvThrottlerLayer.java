package org.burroloco.test.glue.layer;

import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.test.constants.DbTestConstants;

import java.util.List;

public class CsvThrottlerLayer implements Layer, DbTestConstants {
    private Object ref;
    Nu nu;

    public CsvThrottlerLayer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        Cake cake = (Cake) method.invoke(ref, args);
        return trimmedTable(cake);
    }

    private Cake trimmedTable(Cake in) {
        Cake out = nu.nu(Cake.class);
        out.addAll(throttle(in));
        return out;
    }

    private List<Slice> throttle(Cake cake) {
        List<Slice> list = cake.slices();
        return list.subList(0, Math.min(list.size(), MAX_ROWS));
    }

}

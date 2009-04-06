package org.burroloco.test.glue.layer;

import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import org.burroloco.donkey.input.database.SqlWrapper;
import static org.burroloco.test.constants.DbTestConstants.SQL_TOKEN;
import static org.burroloco.test.constants.TestConstants.MAX_ROWS;

public class SybaseThrottlingLayer implements Layer {
    private static final String THROTTLER = "select top " + MAX_ROWS + " a.* from (" + SQL_TOKEN + ") a";
    private Object ref;
    SqlWrapper wrapper;

    public SybaseThrottlingLayer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        String sql = (String) method.invoke(ref, args);
        return wrapper.wrap(sql, THROTTLER);
    }
}
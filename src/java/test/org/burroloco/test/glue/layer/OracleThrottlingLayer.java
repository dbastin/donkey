package org.burroloco.test.glue.layer;

import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import org.burroloco.donkey.input.database.SqlWrapper;
import static org.burroloco.test.constants.DbTestConstants.MAX_ROWS;
import static org.burroloco.test.constants.DbTestConstants.SQL_TOKEN;

public class OracleThrottlingLayer implements Layer {
    private static final String THROTTLE = "select * from (" + SQL_TOKEN + ") where rownum <= " + MAX_ROWS;
    private Object ref;
    SqlWrapper wrapper;

    public OracleThrottlingLayer(Object ref) {
        this.ref = ref;
    }

    public Object invoke(Method method, Object[] args) {
        String sql = (String) method.invoke(ref, args);
        return wrapper.wrap(sql, THROTTLE);
    }
}
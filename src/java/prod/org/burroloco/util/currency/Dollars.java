package org.burroloco.util.currency;

import org.burroloco.donkey.data.cake.Slice;

import java.math.BigDecimal;

public interface Dollars {
    BigDecimal round(Slice in, String name);

    BigDecimal aud(Slice in, String name);
}

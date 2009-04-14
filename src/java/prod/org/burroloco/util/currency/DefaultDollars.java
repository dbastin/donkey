package org.burroloco.util.currency;

import org.burroloco.donkey.data.cake.Slice;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.math.MathContext;

// FIX TSR-DONKEY Use or Lose
public class DefaultDollars implements Dollars {
    public BigDecimal round(Slice in, String name) {
        BigDecimal num = number(in, name);
        return round(num);
    }

    public BigDecimal aud(Slice in, String name) {
        String mode = (String) in.value("QUOTATIONMODE");
        BigDecimal rate = round(in, "RATE");
        BigDecimal amount = round(in, name);
        return mode.equals("D")
                ? round(amount.multiply(rate))
                : round(amount.divide(rate, MathContext.DECIMAL32));
    }

    private BigDecimal round(BigDecimal num) {
        return num.setScale(2, ROUND_HALF_UP);
    }

    private BigDecimal number(Slice in, String name) {
        Double d = (Double) in.value(name);
        return new BigDecimal(d);
    }

}

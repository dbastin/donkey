package org.burroloco.util.currency;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;

// FIX TSR-DONKEY Use or Lose
public class DefaultCurrencyUtil implements CurrencyUtil, Constructable {
    private DecimalFormat numberFormat;
    Impl impl;

    public void constructor() {
        numberFormat = impl.impl(DecimalFormat.class);
    }

    public String format(String amount, String currencyCode) {
        NumberFormat numberFormat = formatter(currencyCode);
        double value = Double.parseDouble(amount);
        return numberFormat.format(value);
    }

    private NumberFormat formatter(String currencyCode) {
        Currency currency = Currency.getInstance(currencyCode);
        numberFormat.setCurrency(currency);
        numberFormat.setMinimumFractionDigits(currency.getDefaultFractionDigits());
        return numberFormat;
    }
}

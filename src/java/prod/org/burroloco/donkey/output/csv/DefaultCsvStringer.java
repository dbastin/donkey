package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;

public class DefaultCsvStringer implements CsvStringer {
    HeaderAndBodyProcessor headerAndBodyProcessor;

    public String text(Cake cake) {
        StringBuilder buffy = new StringBuilder();
        headerAndBodyProcessor.process(cake, buffy);
        return buffy.toString();
    }

}
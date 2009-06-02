package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;

public class DefaultCsvStringer implements CsvStringer {
    HeaderProcessor headerProcessor;
    BodyProcessor bodyProcessor;

    public String text(Cake cake) {
        StringBuilder buffy = new StringBuilder();
        headerProcessor.process(cake, buffy);
        bodyProcessor.process(cake, buffy);
        return buffy.toString();
    }

}
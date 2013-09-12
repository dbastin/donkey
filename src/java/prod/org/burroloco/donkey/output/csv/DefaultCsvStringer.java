package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.core.Data;

public class DefaultCsvStringer implements CsvStringer {
    HeaderProcessor headerProcessor;
    BodyProcessor bodyProcessor;

    public String text(Data data) {
        StringBuilder buffy = new StringBuilder();
        headerProcessor.process(data, buffy);
        bodyProcessor.process(data, buffy);
        return buffy.toString();
    }

}
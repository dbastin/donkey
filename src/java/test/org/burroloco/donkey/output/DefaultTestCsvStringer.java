package org.burroloco.donkey.output;

import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.csv.CsvStringer;

public class DefaultTestCsvStringer implements TestCsvStringer {
    CsvStringer stringer;

    public String text(Cake cake) {
        String text = stringer.text(cake);
        return text.replace("\"\"", "");
    }
}

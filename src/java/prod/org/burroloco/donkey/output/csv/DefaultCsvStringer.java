package org.burroloco.donkey.output.csv;

import static org.burroloco.donkey.util.FileConstants.WIN_EOL;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class DefaultCsvStringer implements CsvStringer {
    ValueProcessor valueProcessor;

    public String text(Cake cake) {
        StringBuilder buffy = new StringBuilder();
        header(cake, buffy);
        body(cake, buffy);
        return buffy.toString();
    }

    private void header(Cake cake, StringBuilder results) {
        Set<String> columns = cake.columnNames();
        values(results, columns);
    }

    private void body(Cake cake, StringBuilder results) {
        List<Slice> rows = cake.slices();
        for (Slice slice : rows) {
            lineEnd(results);
            processSlice(results, slice);
        }
    }

    private void processSlice(StringBuilder results, Slice slice) {
        values(results, slice.values());
    }

    private void values(StringBuilder results, Collection values) {
        Object[] objects = values.toArray();
        for (int i = 0; i < objects.length; i++) {
            if (i > 0) results.append(",");
            Object value = objects[i];
            results.append(valueProcessor.string(value));
        }
    }

    private void lineEnd(StringBuilder line) {
        line.append(WIN_EOL);
    }


}

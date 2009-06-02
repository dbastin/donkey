package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import static org.burroloco.donkey.util.FileConstants.WIN_EOL;

import java.util.List;
import java.util.Set;

public class DefaultHeaderAndBodyProcessor implements HeaderAndBodyProcessor {
    SliceProcessor sliceProcessor;

    public StringBuilder process(Cake cake, StringBuilder stringBuilder) {
        header(cake, stringBuilder);
        body(cake, stringBuilder);
        return stringBuilder;
    }

    private void header(Cake cake, StringBuilder results) {
        Set<String> columns = cake.columnNames();
        sliceProcessor.values(results, columns);
        lineEnd(results);
    }

    private void body(Cake cake, StringBuilder results) {
        List<Slice> rows = cake.slices();
        for (Slice slice : rows) {
            processSlice(results, slice);
            lineEnd(results);
        }
    }

    private void processSlice(StringBuilder results, Slice slice) {
        sliceProcessor.values(results, slice.values());
    }

    private void lineEnd(StringBuilder line) {
        line.append(WIN_EOL);
    }
}

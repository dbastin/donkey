package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import static org.burroloco.donkey.util.FileConstants.WIN_EOL;

import java.util.List;

public class DefaultBodyProcessor implements BodyProcessor{
    SliceProcessor sliceProcessor;

    public void process(Cake cake, StringBuilder results) {
        List<Slice> rows = cake.slices();
        for (Slice slice : rows) {
            processSlice(results, slice);
            results.append(WIN_EOL);
        }
    }

    private void processSlice(StringBuilder results, Slice slice) {
        sliceProcessor.values(results, slice.values());
    }

}

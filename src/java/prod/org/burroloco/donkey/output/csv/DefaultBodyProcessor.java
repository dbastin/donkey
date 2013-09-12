package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Data;
import org.burroloco.donkey.data.cake.Tuple;

import static org.burroloco.donkey.util.FileConstants.WIN_EOL;

import java.util.List;

public class DefaultBodyProcessor implements BodyProcessor{
    SliceProcessor sliceProcessor;

    public void process(Data data, StringBuilder results) {
        List<Tuple> tuples = data.tuples();
        for (Tuple tuple : tuples) {
            processSlice(results, tuple);
            results.append(WIN_EOL);
        }
    }

    private void processSlice(StringBuilder results, Tuple tuple) {
        sliceProcessor.values(results, tuple.values());
    }

}

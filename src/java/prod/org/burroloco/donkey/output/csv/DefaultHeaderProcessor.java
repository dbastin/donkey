package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;
import static org.burroloco.donkey.util.FileConstants.WIN_EOL;

import java.util.Set;

public class DefaultHeaderProcessor implements HeaderProcessor {
    SliceProcessor sliceProcessor;

    public void process(Cake cake, StringBuilder results) {
        Set<String> columns = cake.columnNames();
        sliceProcessor.values(results, columns);
        results.append(WIN_EOL);
    }

}

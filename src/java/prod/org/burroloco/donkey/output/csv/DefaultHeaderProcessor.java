package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Data;

import static org.burroloco.donkey.util.FileConstants.WIN_EOL;

import java.util.Set;

public class DefaultHeaderProcessor implements HeaderProcessor {
    SliceProcessor sliceProcessor;

    public void process(Data data, StringBuilder results) {
        Set<String> columns = data.columnNames();
        sliceProcessor.values(results, columns);
        results.append(WIN_EOL);
    }

}

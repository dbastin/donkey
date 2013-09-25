package org.burroloco.donkey.spit.csv;

import org.burroloco.donkey.data.core.Data;

import java.util.Set;

import static org.burroloco.donkey.util.FileConstants.WIN_EOL;

public class DefaultHeaderProcessor implements HeaderProcessor {
    SliceProcessor sliceProcessor;

    public void process(Data data, StringBuilder results) {
        Set<String> columns = data.columnNames();
        sliceProcessor.values(results, columns);
        results.append(WIN_EOL);
    }

}

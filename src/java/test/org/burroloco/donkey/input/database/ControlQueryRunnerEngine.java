package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.csv.CsvReader;
import org.burroloco.donkey.input.csv.ListConverter;

import java.util.List;

public class ControlQueryRunnerEngine implements QueryRunnerEngine {
    private final InputFileName cannedResults;
    DatabaseNullConverter nullConverter;
    ListConverter listConverter;
    CsvReader csvReader;
    Nu nu;

    public ControlQueryRunnerEngine(InputFileName cannedResults) {
        this.cannedResults = cannedResults;
    }

    public Cake query(Config config, String sqlStatement) {
        List list = csvReader.read(cannedResults);
        List results = nullConverter.convert(list);
        return listConverter.convert(results);
    }
}

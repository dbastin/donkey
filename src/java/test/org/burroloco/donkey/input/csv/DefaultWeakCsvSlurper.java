package org.burroloco.donkey.input.csv;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;

public class DefaultWeakCsvSlurper implements WeakCsvSlurper {
    CsvSlurperEngine delegate;
    Nu nu;
    
    public Cake slurp(String filename) {
        InputFileName file = nu.nu(InputFileName.class, filename);
        return delegate.slurp(file);
    }
}

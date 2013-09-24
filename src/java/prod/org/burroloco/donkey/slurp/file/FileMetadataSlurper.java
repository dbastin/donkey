package org.burroloco.donkey.slurp.file;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.InputFileNames;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.util.csv.CommaSeparatedValues;

import java.io.File;
import java.util.List;

public class FileMetadataSlurper implements Slurper {
    CommaSeparatedValues separated;
    FileUtilsStatic files;
    WeakConfig weak;
    Weaken weaken;
    Nu nu;
    
    public Data slurp(Config config) {
        Data data = nu.nu(Data.class);
        InputDirName dir = config.get(InputDirName.class);
        String list = weak.get(config, InputFileNames.class);
        List<String> names = separated.list(list);
        for (String name : names) slurp(data, dir, name);
        return data;
    }

    private void slurp(Data data, InputDirName dir, String name) {
        Tuple tuple = nu.nu(Tuple.class);
        slurp(tuple, dir, name);
        data.add(tuple);
    }

    private void slurp(Tuple tuple, InputDirName dir, String name) {
        File file = new File(weaken.w(dir), name);
        tuple.add("FileName", file.getName());
        tuple.add("LineCount", lines(file));
        tuple.add("ByteCount", bytes(file));
    }

    private int lines(File file) {
        List lines = files.readLines(file);
        return lines.size();
    }

    private long bytes(File file) {
        return file.length();
    }
}

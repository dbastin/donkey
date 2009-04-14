package org.burroloco.donkey.input.file;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.InputFileNames;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.util.csv.CommaSeparatedValues;

import java.io.File;
import java.util.List;

// FIX TSR-DONKEY Use or Lose
public class FileMetaSlurper implements Slurper {
    CommaSeparatedValues separated;
    FileUtilsStatic files;
    WeakConfig weak;
    Weaken weaken;
    Nu nu;
    
    public Cake slurp(Config config) {
        Cake cake = nu.nu(Cake.class);
        InputDirName dir = config.get(InputDirName.class);
        String list = weak.get(config, InputFileNames.class);
        List<String> names = separated.list(list);
        for (String name : names) slurp(cake, dir, name);
        return cake;
    }

    private void slurp(Cake cake, InputDirName dir, String name) {
        Slice slice = nu.nu(Slice.class);
        slurp(slice, dir, name);
        cake.add(slice);
    }

    private void slurp(Slice slice, InputDirName dir, String name) {
        File file = new File(weaken.w(dir), name);
        slice.add("FileName", file.getName());
        slice.add("LineCount", lines(file));
        slice.add("ByteCount", bytes(file));
    }

    private int lines(File file) {
        List lines = files.readLines(file);
        return lines.size();
    }

    private long bytes(File file) {
        return file.length();
    }
}

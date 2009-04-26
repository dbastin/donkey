package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.io.FileWriter;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.data.cake.Slice;

import java.io.File;

public class ReportingHandler implements TransformErrorHandler {
    private static final boolean APPEND = true;
    private final File name;
    FileUtilsStatic fileUtils;
    Weaken weaken;
    Nu nu;

    public ReportingHandler(File name) {
        this.name = name;
    }

    public void error(Slice slice, Exception e) {
        FileWriter writer = writer();
        writer.write(msg(slice, e));
        writer.close();
        // FIX TSR-4241 Make a report in the .retry format as well as the report...
        // FIX TSR-4241 log as well.
    }

    private FileWriter writer() {
        fileUtils.touch(name);
        return nu.nu(FileWriter.class, name, APPEND);
    }

    private String msg(Slice slice, Exception e) {
        return e.getMessage() + " for slice: " + slice.toString() + LINE + LINE;
    }
}

package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.io.FileWriter;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.data.cake.Slice;

import java.io.File;

public class ErrorReportPuker implements Puker {
    private static final boolean APPEND = true;
    private final File report;
    FileUtilsStatic fileUtils;
    Weaken weaken;
    Nu nu;

    public ErrorReportPuker(File report) {
        this.report = report;
    }

    // FIX TSR-4241 Wire this in to the migration code...
    public void puke(Slice slice, RuntimeException e) {
        report(slice, e);
        // FIX TSR-4241 Make a report in the .retry format as well as the report...
        // FIX TSR-4241 log as well.
    }

    private void report(Slice slice, RuntimeException e) {
        FileWriter writer = writer();
        writer.write(error(slice, e));
        writer.close();
    }

    private FileWriter writer() {
        // FIX TSR-4241 Use the fileWizard?
        fileUtils.touch(report);
        return nu.nu(FileWriter.class, report, APPEND);
    }

    // FIX TSR-4241 Make this better....
    private String error(Slice slice, RuntimeException e) {
        return e.getMessage() + " for slice: " + slice.toString() + LINE + LINE;
    }
}

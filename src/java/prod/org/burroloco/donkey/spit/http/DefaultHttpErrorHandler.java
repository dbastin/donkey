package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.util.FileStamper;

import java.io.File;

import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class DefaultHttpErrorHandler implements HttpErrorHandler {

    FileUtilsStatic files;
    FileStamper stamper;
    Weaken weaken;

    public void handle(Tuple t, int status, ErrorDirName dir) {
        File f = errorFile(status, dir);
        String v = (String) t.value(UNIT_KEY);
        files.writeStringToFile(f, v);
    }

    private File errorFile(int statusCode, ErrorDirName dir) {
        String d = weaken.w(dir);
        String name = statusCode + ".txt";
        return new File(d, stamper.stamp(name));
    }
}

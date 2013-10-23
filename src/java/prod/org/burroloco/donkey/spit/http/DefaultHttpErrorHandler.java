package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.bullet.log.Log;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.config.HttpsUrl;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.util.FileStamper;

import java.io.File;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class DefaultHttpErrorHandler implements HttpErrorHandler {

    FileUtilsStatic files;
    FileStamper stamper;
    Weaken weaken;
    Log log;

    public void handle(Tuple t, ErrorDirName dir, HttpsUrl url, int status) {
        File f = errorFile(status, dir);
        String v = (String) t.value(UNIT_KEY);
        files.writeStringToFile(f, v);
        logError(status, v, url);
    }

    private File errorFile(int statusCode, ErrorDirName dir) {
        String d = weaken.w(dir);
        String name = statusCode + ".txt";
        return new File(d, stamper.stamp(name));
    }

    private void logError(int status, String v, HttpsUrl url) {
        log.error("URL: " + weaken.w(url));
        log.error("Response Code: " + status);
        log.error("Sent... " + LINE_SEPARATOR + v);
    }
}

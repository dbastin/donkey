package org.burroloco.donkey.trebuchet;

import org.burroloco.test.glue.env.TestTokens;
import org.burroloco.test.util.io.FileWirer;
import org.burroloco.test.util.io.Replace;

import java.io.File;

public class DefaultInstallSimulator implements InstallSimulator {
    private static final String TRADEKAST_PROPERTIES = "config/interface/riskvision/tradekast.properties";
    private static final String TIBCO_PROPERTIES = "config/interface/riskvision/tibco.properties";
    private static final String DB_PROPERTIES = "config/db/kondor.properties";
    TestTokens tokens;
    Replace replace;
    FileWirer file;

    public void install() {
        replace(DB_PROPERTIES);
        replace(TIBCO_PROPERTIES);
        replace(TRADEKAST_PROPERTIES);
    }

    private void replace(String filename) {
        File propFile = file.file(filename);
        replace.exec(propFile, propFile, tokens.replacements());
    }
}

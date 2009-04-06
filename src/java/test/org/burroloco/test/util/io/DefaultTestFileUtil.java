package org.burroloco.test.util.io;

// TODO Combine with FileUtil in src/prod?
public class DefaultTestFileUtil implements TestFileUtil {
    LocalHost localHost;

    // FIX DONKEY System number...
    public String uniqueName(String templateName) {
        return localHost.shortName() + "-" + 6 + "-" + templateName;
    }

    public String removeExtension(String filename) {
        int extensionStart = filename.lastIndexOf(".");
        return filename.substring(0, extensionStart);
    }
}

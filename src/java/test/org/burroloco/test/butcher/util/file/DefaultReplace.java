package org.burroloco.test.butcher.util.file;

import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.util.string.TokenUtil;

import java.io.File;
import java.util.Map;


public class DefaultReplace implements Replace {
    FileUtilsStatic fileUtils;
    TokenUtil tokenUtil;

    public void exec(File source, File dest, Map<String, String> replacements) {
        String input = fileUtils.readFileToString(source);
        String output = tokenUtil.replace(input, replacements);
        fileUtils.writeStringToFile(dest, output);
    }
}

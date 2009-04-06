package org.burroloco.interfaces.common.checker;

import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.test.util.expression.DatabaseExpressionResolver;
import org.burroloco.test.util.mnemonic.MnemonicFilter;

import java.io.File;

public class DefaultMnemonicMan implements MnemonicMan {
    DatabaseExpressionResolver resolver;
    FileUtilsStatic fileUtils;
    MnemonicFilter filter;

    public String read(File file) {
        String content = fileUtils.readFileToString(file);
        String enved = filter.filter(content);
        return resolver.resolve(enved);
    }

    public void copyFile(File from, File to) {
        fileUtils.writeStringToFile(to, read(from));
    }

    public void copyDir(File source, File dest) {
        for (File from : source.listFiles()) {
            String name = from.getName();
            if (name.equals(".svn")) continue;
            File to = new File(dest, from.getName());
            copyFile(from, to);
        }
    }
}

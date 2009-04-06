package org.burroloco.interfaces.common.checker;

import java.io.File;

public interface MnemonicMan {
    String read(File file);
    void copyFile(File from, File to);
    void copyDir(File from, File to);
}

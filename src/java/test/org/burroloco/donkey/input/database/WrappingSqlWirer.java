package org.burroloco.donkey.input.database;

import java.io.File;

public interface WrappingSqlWirer {
    void wire(File wrapTemplate);

    void wire(String wrapTemplate);
}

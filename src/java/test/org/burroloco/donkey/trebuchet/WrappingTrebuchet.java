package org.burroloco.donkey.trebuchet;

import java.io.File;

public interface WrappingTrebuchet {
    void launch(Class<? extends Specification> speCls, File sqlWrap);
}

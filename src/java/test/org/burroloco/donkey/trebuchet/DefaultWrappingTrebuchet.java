package org.burroloco.donkey.trebuchet;

import org.burroloco.donkey.input.database.WrappingSqlWirer;

import java.io.File;

public class DefaultWrappingTrebuchet implements WrappingTrebuchet {
    WrappingSqlWirer wirer;
    Trebuchet trebuchet;

    public void launch(Class<? extends Job> payload, File sqlWrap) {
        wirer.wire(sqlWrap);
        trebuchet.launch(payload);
    }
}

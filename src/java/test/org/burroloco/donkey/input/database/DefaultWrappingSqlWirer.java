package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.interfaces.common.checker.MnemonicMan;

import java.io.File;

public class DefaultWrappingSqlWirer implements WrappingSqlWirer {
    MnemonicMan man;
    Wire wire;

    public void wire(File templateFile) {
        wire(man.read(templateFile));
    }

    public void wire(String wrapTemplate) {
        wire.impl(WrappingSqlBuilder.class, wrapTemplate).to(SqlBuilder.class);
    }
}
package org.burroloco.test.glue.web;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import edge.java.net.InetAddressStatic;
import org.burroloco.config.loader.PropertiesLoader;
import org.burroloco.shed.model.Environment;
import org.burroloco.shed.model.Environments;
import org.burroloco.test.glue.env.DbParameters;
import org.burroloco.test.glue.env.EnvPropertyGetter;
import org.burroloco.test.glue.env.LocalParameters;
import org.burroloco.test.util.mnemonic.MnemonicBuilder;

import java.io.File;

public class EnvironmentWeb implements Web {
    InetAddressStatic addressStatic;
    Environments environments;
    MnemonicBuilder mnemonics;
    PropertiesLoader loader;
    EnvPropertyGetter prop;
    Wire wire;
    
    public void web() {
        String hostName = addressStatic.getLocalHost().getHostName();
        StrictMap<String, String> localProps = localProps(hostName);
        String muppet = prop.get(localProps, "environment");
        Environment env = environments.get(muppet);
        String mnemonic = mnemonics.mnemonic(hostName, localProps);
        String dbPort = "5" + env.number() + "00";
        bind(env, dbPort, mnemonic);
    }

    private void bind(Environment env, String dbPort, String mnemonic) {
        wire.nu(LocalParameters.class, mnemonic).to(LocalParameters.class);
        wire.nu(DbParameters.class, env.host(), dbPort).to(DbParameters.class);
    }

    private StrictMap<String, String> localProps(String hostName) {
        String filename = "build/config/profile/" + hostName + ".properties";
        return new File(filename).exists() ? loader.load(filename) : new DefaultStrictMap<String, String>();
    }
}

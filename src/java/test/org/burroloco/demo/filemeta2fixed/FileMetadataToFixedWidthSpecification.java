package org.burroloco.demo.filemeta2fixed;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class FileMetadataToFixedWidthSpecification implements Specification {
    private static final String[] PROPS = {
            "config/filemeta2fixed/filemeta2fixed.properties",
            "config/filemeta2fixed/filemeta2fixed-override.properties"
    };
    ConfigLoader loader;

    public Config config() {
        return loader.overload(PROPS);
    }

    public Class<? extends Wirer> wirer() {
        return FileMetadataToFixedWidthWirer.class;
    }
}

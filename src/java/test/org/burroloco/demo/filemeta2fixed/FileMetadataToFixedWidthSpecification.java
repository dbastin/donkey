package org.burroloco.demo.filemeta2fixed;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class FileMetadataToFixedWidthSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.overload("config/filemeta2fixed.properties", "config/filemeta2fixed-override.properties");
    }

    public Class<? extends Wirer> wirer() {
        return FileMetadataToFixedWidthWirer.class;
    }
}

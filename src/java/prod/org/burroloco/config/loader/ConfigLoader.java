package org.burroloco.config.loader;

import org.burroloco.config.core.Config;

public interface ConfigLoader {
    Config load(String... filenames);

    Config overload(String... filenames);
}

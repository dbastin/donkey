package org.burroloco.config.loader;

import org.burroloco.config.core.Config;

public interface ConfigLoaderEngine {
    Config load(boolean allowOverride, String... filenames);
}

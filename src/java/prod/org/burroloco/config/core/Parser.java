package org.burroloco.config.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;

public interface Parser {
    <T extends Strong> T parse(Class<T> type, String value);
}

package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

public interface Subject extends Struct {
    String name();
    String[] keys();
}

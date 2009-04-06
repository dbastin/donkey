package org.burroloco.shed.model;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

public interface ServiceStatus extends Struct {
    Service service();
    Status status();
}

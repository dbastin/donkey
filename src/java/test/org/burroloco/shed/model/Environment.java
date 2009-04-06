package org.burroloco.shed.model;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

// OK ConstantName {
public interface Environment extends Struct {
    String[] _ = {"name", "host", "number"};
    
    String name();
    String host();
    Integer number();
}
// }

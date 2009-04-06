package org.burroloco.shed.model;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

// OK ConstantName {
public interface Service extends Struct {
    String[] _ = {"user", "name"};
    
    String user();
    String name();
}
// }
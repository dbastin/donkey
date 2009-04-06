package org.burroloco.shed.model;

import java.util.List;

public interface Environments {
    Environment get(String muppet);

    List<Environment> all();
}

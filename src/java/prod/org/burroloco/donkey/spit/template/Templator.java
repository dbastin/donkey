package org.burroloco.donkey.spit.template;

import org.burroloco.donkey.data.core.Tuple;

public interface Templator {
    String apply(Tuple tuple, String template);
}

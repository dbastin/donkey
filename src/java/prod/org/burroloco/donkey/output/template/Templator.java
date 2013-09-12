package org.burroloco.donkey.output.template;

import org.burroloco.donkey.data.cake.Tuple;

public interface Templator {
    String apply(Tuple tuple, String template);
}

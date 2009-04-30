package org.burroloco.donkey.output.template;

import org.burroloco.donkey.data.cake.Slice;

public interface Templator {
    String apply(Slice slice, String template);
}

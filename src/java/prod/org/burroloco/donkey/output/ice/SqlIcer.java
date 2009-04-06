package org.burroloco.donkey.output.ice;

import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.transformation.transform.Icer;

public interface SqlIcer extends Icer {
    Cake transform(Cake in);
}

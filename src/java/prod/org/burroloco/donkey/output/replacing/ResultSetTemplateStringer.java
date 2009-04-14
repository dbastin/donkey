package org.burroloco.donkey.output.replacing;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

// FIX TSR-DONKEY Use or Lose
public class ResultSetTemplateStringer implements TemplateStringer {
    TemplateStringer stringer;

    public String text(Config config, Cake cake) {
        StringBuilder result = new StringBuilder();
        result.append("<ResultSet>").append(LINE);
        result.append(stringer.text(config, cake));
        result.append("</ResultSet>").append(LINE);
        return result.toString();
    }
}

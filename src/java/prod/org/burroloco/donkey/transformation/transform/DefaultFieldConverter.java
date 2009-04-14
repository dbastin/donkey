package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.input.database.DatabaseNull;
import static org.burroloco.donkey.transformation.transform.TransformConstants.EMPTY_FIELD;

// FIX TSR-DONKEY Use or Lose
public class DefaultFieldConverter implements FieldConverter {
    Nu nu;

    public Slice nullTo(Slice in, Object replacement) {
        return convert(in, new DatabaseNull(), replacement);
    }

    public Slice emptyTo(Slice in, Object replacement) {
        return convert(in, EMPTY_FIELD, replacement);
    }

    private Slice convert(Slice in, Object target, Object replacement) {
        Slice converted  = nu.nu(Slice.class);
        for (String name : in.names()) {
            Object value = in.value(name);
            if(target.equals(value)){
                converted.add(name,replacement);
            }else
                converted.add(name,value);
        }
        return converted;
    }
}

package org.burroloco.donkey.data.cake;

import java.util.Map;

public interface Slicer {
    Slice copy(Slice slice);

    Map<String, String> stringMap(Slice slice);
}

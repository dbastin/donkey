package org.burroloco.interfaces.common.checker;

import junit.framework.AssertionFailedError;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

import java.util.HashSet;
import java.util.Set;

public class DefaultUniqueCakeJudge implements UniqueCakeJudge {
    public void check(Cake cake, String col) {
        Set ids = new HashSet();
        for (Slice slice : cake.slices()) checkPrimaryKey(col, ids, slice);
    }


    private void checkPrimaryKey(String col, Set ids, Slice slice) {
        Object id = slice.value(col);
        if (ids.contains(id)) bang(slice, col, id);
        ids.add(id);
    }

    private void bang(Slice slice, String col, Object id) {
        throw new AssertionFailedError("Duplicate id [" + id + "] found for column [" + col + "]: " + slice);
    }


}

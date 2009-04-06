package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import org.burroloco.donkey.data.error.ColumnMismatchException;
import org.burroloco.donkey.data.error.EmptyCakeException;

import java.util.ArrayList;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.Set;

public class DefaultCake extends Primordial implements Cake {
    private List<Slice> slices = new ArrayList<Slice>();
    private boolean cold = false;

    public void add(Slice slice) {
        safeAdd(slice);
    }

    public void addAll(List<Slice> slices) {
        for (Slice slice : slices) safeAdd(slice);
    }

    public List<Slice> slices() {
        return unmodifiableList(slices);
    }

    public Set<String> columnNames() {
        check();
        return firstNames();
    }

    public void refrigerate() {
        cold = true;
        check();
    }

    private void safeAdd(Slice slice) {
        if (cold) pop();
        checkColumnNames(slice);
        slices.add(slice);
    }

    private void checkColumnNames(Slice slice) {
        if (slices.isEmpty()) return;
        Set<String> cols = firstNames();
        Set<String> newCols = slice.names();
        if (!cols.equals(newCols)) throw new ColumnMismatchException(cols, newCols);
    }

    private Set<String> firstNames() {
        return slices.get(0).names();
    }

    private void pop() {
        throw new IllegalArgumentException("Can't modify a complete Cake.");
    }

    private void check() {
        if (slices.isEmpty()) throw new EmptyCakeException("No Slices... you can't have an empty Cake and eat it too.");
    }
}

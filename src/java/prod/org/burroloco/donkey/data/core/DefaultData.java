package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import org.burroloco.donkey.data.error.ColumnMismatchException;
import org.burroloco.donkey.data.error.NoDataException;

import java.util.ArrayList;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.Set;

public class DefaultData extends Primordial implements Data {
    private List<Tuple> tuples = new ArrayList<Tuple>();
    private boolean readOnly = false;

    public void add(Tuple tuple) {
        safeAdd(tuple);
    }

    public void addAll(List<Tuple> tuples) {
        for (Tuple tuple : tuples) safeAdd(tuple);
    }

    public List<Tuple> tuples() {
        return unmodifiableList(tuples);
    }

    public Set<String> columnNames() {
        check();
        return firstNames();
    }

    public void readOnly() {
        readOnly = true;
        check();
    }

    private void safeAdd(Tuple tuple) {
        if (readOnly) throw new IllegalArgumentException("Data is read only.");
        checkColumnNames(tuple);
        tuples.add(tuple);
    }

    private void checkColumnNames(Tuple tuple) {
        if (tuples.isEmpty()) return;
        Set<String> cols = firstNames();
        Set<String> newCols = tuple.names();
        if (!cols.equals(newCols)) throw new ColumnMismatchException(cols, newCols);
    }

    private Set<String> firstNames() {
        return tuples.get(0).names();
    }

    private void check() {
        if (tuples.isEmpty()) throw new NoDataException("Data is empty.");
    }
}

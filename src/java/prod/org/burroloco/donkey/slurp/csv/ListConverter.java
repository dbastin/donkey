package org.burroloco.donkey.slurp.csv;

import org.burroloco.donkey.data.core.Data;

import java.util.List;

public interface ListConverter {
    Data convert(List rows);
}

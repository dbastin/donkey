package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.data.cake.Data;

import java.util.List;

public interface ListConverter {
    Data convert(List rows);
}

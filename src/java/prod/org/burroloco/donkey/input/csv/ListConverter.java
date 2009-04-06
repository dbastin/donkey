package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.data.cake.Cake;

import java.util.List;

public interface ListConverter {
    Cake convert(List rows);
}

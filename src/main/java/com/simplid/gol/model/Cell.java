package com.simplid.gol.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Arrays;

@JsonDeserialize(using = CellDeserializer.class)
@JsonSerialize(using = CellSerializer.class)
public enum Cell {
    dead(0),
    alive(1);

    private final int value;

    Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Cell fromValue(final int value) {
        return Arrays.stream(Cell.values())
                .filter(c -> c.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No cell element for value [" + value + "]!"));
    }
}

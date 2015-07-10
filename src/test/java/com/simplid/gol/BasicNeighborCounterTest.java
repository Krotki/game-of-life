package com.simplid.gol;

import static org.assertj.core.api.Assertions.*;

import com.simplid.gol.logic.BasicNeighborCounter;
import com.simplid.gol.model.Board;
import com.simplid.gol.model.Cell;
import org.junit.Test;

public class BasicNeighborCounterTest {

    @Test
    public void countTest() {
        Board board = new Board(3, 3);
        board.set(0, 0, Cell.alive);
        board.set(2, 2, Cell.alive);

        BasicNeighborCounter basicNeighborCounter = new BasicNeighborCounter();
        int count = basicNeighborCounter.count(board, 0, 0);
        assertThat(count).isEqualTo(0);
        count = basicNeighborCounter.count(board, 1, 1);
        assertThat(count).isEqualTo(2);
        count = basicNeighborCounter.count(board, 1, 2);
        assertThat(count).isEqualTo(1);
    }

}
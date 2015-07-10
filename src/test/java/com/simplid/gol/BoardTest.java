package com.simplid.gol;

import com.simplid.gol.model.Board;
import com.simplid.gol.model.Cell;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BoardTest {

    @Test
    public void testGetSet() throws Exception {
        Board board = new Board(3, 6);
        Cell cell = board.get(2, 5);
        assertThat(cell).isEqualTo(Cell.dead);
        board.set(2, 5, Cell.alive);
        cell = board.get(2, 5);
        assertThat(cell).isEqualTo(Cell.alive);
    }

    @Test
    public void testCreateRandom() throws Exception {
        int width = 30;
        int height = 20;
        int deadCount = 0;
        int aliveCount = 0;
        int min = width * height / 2;
        min = min - (int)(min * 0.2);
        Board board = Board.createRandom(width, height);

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
               if (board.get(i, j) == Cell.alive) {
                   aliveCount++;
               } else {
                   deadCount++;
               }
            }
        }

        assertThat(deadCount).isGreaterThan(min);
        assertThat(aliveCount).isGreaterThan(min);
    }
}
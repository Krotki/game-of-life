package com.simplid.gol.logic;

import com.simplid.gol.model.Board;
import com.simplid.gol.model.Cell;
import org.springframework.stereotype.Component;

@Component
public class BasicNeighborCounter implements INeighborCounter {

    public int count(Board board, int x, int y) {
        int count = 0;
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                if(i == x && j == y) {
                    continue;
                }
                try {
                    Cell cell = board.get(i, j);
                    if(cell == Cell.alive) {
                        count++;
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
        return count;
    }
}

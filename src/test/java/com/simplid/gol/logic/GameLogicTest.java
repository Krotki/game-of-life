package com.simplid.gol.logic;

import com.simplid.gol.model.Board;
import com.simplid.gol.model.Cell;
import com.simplid.gol.model.Game;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameLogicTest {

    @Test
    public void testNextGeneration() throws Exception {
        Board board = new Board(4, 4);
        board.set(1 ,1, Cell.alive);
        board.set(1, 2, Cell.alive);
        board.set(2, 1, Cell.alive);
        board.set(2, 2, Cell.alive);
        Game game = new Game("id", "testGame", 0, board);
        GameLogic gameLogic = new GameLogic(new BasicNeighborCounter());

        Game nextGame = gameLogic.nextGeneration(game);

        assertThat(nextGame.getGeneration()).isEqualTo(1);
        assertThat(nextGame.getBoard().get(0, 0)).isEqualTo(Cell.dead);
        assertThat(nextGame.getBoard().get(3, 3)).isEqualTo(Cell.dead);
        assertThat(nextGame.getBoard().get(1, 1)).isEqualTo(Cell.alive);
        assertThat(nextGame.getBoard().get(1, 2)).isEqualTo(Cell.alive);
        assertThat(nextGame.getBoard().get(2, 1)).isEqualTo(Cell.alive);
        assertThat(nextGame.getBoard().get(2, 2)).isEqualTo(Cell.alive);
    }
}
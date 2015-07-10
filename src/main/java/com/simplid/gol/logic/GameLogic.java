package com.simplid.gol.logic;

import com.simplid.gol.model.Board;
import com.simplid.gol.model.Cell;
import com.simplid.gol.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameLogic implements IGameLogic {

    private final INeighborCounter neighborCounter;

    @Autowired
    public GameLogic(INeighborCounter neighborCounter) {
        this.neighborCounter = neighborCounter;
    }

    public Game nextGeneration(Game game) {
        Board nextBoard = new Board(game.getBoard().getWidth(), game.getBoard().getHeight());
        for(int i = 0; i < game.getBoard().getWidth(); i++) {
            for(int j = 0; j < game.getBoard().getHeight(); j++) {

                int neighborCount = neighborCounter.count(game.getBoard(), i, j);

                // Underpopulation
                if (neighborCount < 2) {
                    nextBoard.set(i, j, Cell.dead);
                }

                // Survival
                if (neighborCount == 2) {
                    nextBoard.set(i, j, game.getBoard().get(i, j));
                }

                // Reproduction
                if(neighborCount == 3) {
                    nextBoard.set(i, j, Cell.alive);
                }

                // Overcrowding
                if(neighborCount > 3) {
                    nextBoard.set(i, j, Cell.dead);
                }
            }
        }
        game.setBoard(nextBoard);
        game.setGeneration(game.getGeneration() + 1);
        return game;
    }

}

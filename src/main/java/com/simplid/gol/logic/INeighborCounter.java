package com.simplid.gol.logic;

import com.simplid.gol.model.Board;

public interface INeighborCounter {

    int count(Board board, int x, int y);
}

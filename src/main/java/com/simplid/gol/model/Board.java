package com.simplid.gol.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private int width;
    private int height;
    private List<List<Cell>> cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new ArrayList<>(height);
        for(int i = 0; i < height; i++) {
            ArrayList<Cell> row = new ArrayList<>(width);
            for(int j = 0; j < width; j++) {
                row.add(Cell.dead);
            }
            cells.add(row);
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public Cell get(int x, int y) {
        return cells.get(y).get(x);
    }

    public void set(int x, int y, Cell cell) {
        cells.get(y).set(x, cell);
    }

    public static Board createRandom(int width, int height) {
        Random rnd = new Random();
        Board board = new Board(width, height);
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                Cell cell = Cell.values()[rnd.nextInt(Cell.values().length)];
                board.set(i, j, cell);
            }
        }
        return board;
    }
}

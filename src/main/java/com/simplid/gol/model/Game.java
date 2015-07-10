package com.simplid.gol.model;

import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private String id;
    private String name;
    private int generation;
    private Board board;

    public Game() {}

    public Game(String name, int width, int height) {
        this(null, name, 0, Board.createRandom(width, height));
    }

    public Game(String id, String name, int generation, Board board) {
        this.id = id;
        this.board = board;
        this.name = name;
        this.generation = generation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}

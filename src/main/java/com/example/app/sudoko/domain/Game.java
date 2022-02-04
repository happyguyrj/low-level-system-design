package com.example.app.sudoko.domain;

import java.util.List;

public class Game {

    private List<List<Integer>> board;
    private GameStatus gameStatus;
    private DifficultyLevel difficultyLevel;
    private int size;
    private int rowFilled;
    private int columnsFilled;

    public Game(List<List<Integer>> board) {
        this.board = board;
    }

    public List<List<Integer>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Integer>> board) {
        this.board = board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRowFilled() {
        return rowFilled;
    }

    public void setRowFilled(int rowFilled) {
        this.rowFilled = rowFilled;
    }

    public int getColumnsFilled() {
        return columnsFilled;
    }

    public void setColumnsFilled(int columnsFilled) {
        this.columnsFilled = columnsFilled;
    }

    public void print() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(board.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }
}

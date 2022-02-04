package com.example.app.sudoko.domain;

import java.util.List;

public class Game {

    private List<List<Integer>> board;
    private GameStatus gameStatus;
    private DifficultyLevel difficultyLevel;
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
}

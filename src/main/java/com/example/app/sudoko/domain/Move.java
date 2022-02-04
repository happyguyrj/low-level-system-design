package com.example.app.sudoko.domain;

public class Move {

    private int row;
    private int col;
    private int num;

    public Move(int row, int col, int num) {
        this.row = row;
        this.col = col;
        this.num = num;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Move{" +
                "row=" + row +
                ", col=" + col +
                ", num=" + num +
                '}';
    }
}

package com.example.app.sudoko.solver;

import com.example.app.sudoko.domain.Game;
import com.example.app.sudoko.domain.Move;

import java.util.List;

public class BackTrackingGameSolverImpl implements GameSolver {

    @Override
    public Game solveGame(Game game) {
        if (solveGameUtil(game))
            return game;

        return null;
    }

    public boolean solveGameUtil(Game game) {
        int currentRow = 0;
        int currentCol = 0;

        boolean isEmpty = true;

        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                if (game.getBoard().get(i).get(j) == 0) {
                    currentRow = i;
                    currentCol = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
                break;
        }

        if (isEmpty)
            return true;

        for (int num = 1; num <= game.getSize(); num++) {
            if (isSafe(new Move(currentRow, currentCol, num), game)) {
                game.getBoard().get(currentRow).set(currentCol, num);

                if (solveGameUtil(game))
                    return true;
                else
                    game.getBoard().get(currentRow).set(currentCol, 0);
            }
        }
        return false;
    }


    // checks if move is safe
    public boolean isSafe(Move move, Game game) {
        if(!isValid(move, game.getSize()))
            return false;

        List<List<Integer>> board = game.getBoard();
        int row = move.getRow();
        int col = move.getCol();
        int num = move.getNum();

        for (int i = 0; i < game.getSize(); i++)
            if (board.get(row).get(i) == num)
                return false;

        for (int i = 0; i < game.getSize(); i++)
            if (board.get(i).get(col) == num)
                return false;

        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;

        for (int i = boxRowStart; i < boxRowStart + 3; i++)
            for (int j = boxColStart; j < boxColStart + 3; j++)
                if (board.get(i).get(j) == num)
                    return false;

        return true;
    }


    // checks if move is valid
    private boolean isValid(Move move, int size) {
        return checkBounds(move.getCol(), size-1) &&
                checkBounds(move.getRow(), size-1) &&
                checkBounds(move.getNum(), size);
    }


    // checks boundaries of move
    private boolean checkBounds(int value, int size) {
        return value <= size && value >= 0;
    }

}

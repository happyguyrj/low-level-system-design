package com.example.app.sudoko;

import com.example.app.sudoko.domain.Game;
import com.example.app.sudoko.domain.GameStatus;
import com.example.app.sudoko.player.GamePlayer;
import com.example.app.sudoko.solver.BackTrackingGameSolverImpl;
import com.example.app.sudoko.solver.GameSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokoDemo {

    public static void main(String[] args) {

        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(8, 0, 0, 0, 0, 0, 0, 0, 0));
        board.add(Arrays.asList(0, 0, 3, 6, 0, 0, 0, 0, 0));
        board.add(Arrays.asList(0, 7, 0, 0, 9, 0, 2, 0, 0));
        board.add(Arrays.asList(0, 5, 0, 0, 0, 7, 0, 0, 0));
        board.add(Arrays.asList(0, 0, 0, 0, 4, 5, 7, 0, 0));
        board.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 3, 0));
        board.add(Arrays.asList(0, 0, 1, 0, 0, 0, 0, 6, 8));
        board.add(Arrays.asList(0, 0, 8, 5, 0, 0, 0, 1, 0));
        board.add(Arrays.asList(0, 9, 0, 0, 0, 0, 4, 0, 0));


        Game game = new Game(board);
        game.setSize(9);

        GameSolver player = new BackTrackingGameSolverImpl();
        game = player.solveGame(game);

        game.print();
    }
}

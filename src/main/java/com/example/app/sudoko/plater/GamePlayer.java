package com.example.app.sudoko.plater;

import com.example.app.sudoko.domain.Game;
import com.example.app.sudoko.domain.GameStatus;
import com.example.app.sudoko.domain.Move;
import com.example.app.sudoko.domain.MoveStatus;

public interface GamePlayer {

    MoveStatus makeMove(Game game, Move move);

    GameStatus checkGameStatus(Game game);
}

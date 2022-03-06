package com.example.app.sudoko.generator;

import com.example.app.sudoko.domain.DifficultyLevel;
import com.example.app.sudoko.domain.Game;

public interface GameGenerator {

    Game generateRandomGame();

    Game generateGame(DifficultyLevel difficultyLevel);
}

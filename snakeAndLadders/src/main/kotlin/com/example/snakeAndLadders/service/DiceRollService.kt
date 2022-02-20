package com.example.snakeAndLadders.service

import kotlin.random.Random

class DiceRollService {

    companion object {
        fun roll(): Int = Random.nextInt(6) + 1
    }

}
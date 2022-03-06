package com.example.snakeAndLadders.domain

class Board(_size: Int) {

    val size: Int = _size
    var snakes: List<Snake> = mutableListOf()
    var ladders: List<Ladder> = mutableListOf()
    var playerPieces: Map<String, Int?> = mutableMapOf()

}
package com.example.snakeAndLadders.service

import com.example.snakeAndLadders.domain.Board
import com.example.snakeAndLadders.domain.Ladder
import com.example.snakeAndLadders.domain.Player
import com.example.snakeAndLadders.domain.Snake
import java.util.*

class SnakeAndLadderService(_size: Int) {

    private val board: Board = Board(_size)
    lateinit var numPlayer: Number
    var players: Queue<Player> = LinkedList()

    fun setPlayers(players:List<Player>) {
        this.players = LinkedList()
        this.numPlayer = players.size
        val playerPieces  = HashMap<String, Int>()
        for (player: Player in players) {
            this.players.add(player)
            playerPieces[player.id] = 0
        }
        board.playerPieces = playerPieces
    }

    fun setSnakes(snakes: List<Snake>) {
        board.snakes = snakes
    }

    fun setLadders(ladders: List<Ladder>) {
        board.ladders = ladders
    }

    private fun getNewPositionAfterGoingThroughSnakesAndLadders(newPosition: Int): Int {
        var previousPosition: Int
        var newPositionAfterMove: Int = newPosition
        do {
            previousPosition = newPosition
            for (snake: Snake in board.snakes)
                if (snake.start == newPosition)
                    newPositionAfterMove = snake.end

            for (ladder: Ladder in board.ladders)
                if (ladder.start == newPosition)
                    newPositionAfterMove = ladder.end

        } while (previousPosition != newPositionAfterMove)
        return newPositionAfterMove
    }

    private fun movePlayer(player: Player, position: Int) {
        val oldPosition: Int? = board.playerPieces.get(player.id)
        var newPosition: Int = position + oldPosition!!

        newPosition = if(newPosition > board.size) {
            oldPosition
        } else {
            getNewPositionAfterGoingThroughSnakesAndLadders(position)
        }

        board.playerPieces += mapOf(player.id to newPosition)
        println("${player.name} rolled a $position and moved from $oldPosition to $newPosition")
    }

    private fun getTotalValueAfterDiceRolls(): Int = DiceRollService.roll()

    private fun hasPlayerWon(player: Player): Boolean {
        val playerPosition: Int? = board.playerPieces.get(player.id)
        val winningPosition: Int = board.size
        return playerPosition == winningPosition
    }

    private fun isGameComplete(): Boolean {
        val currentPlayersNum = players.size
        return currentPlayersNum < numPlayer.toInt()
    }

    fun startGame() {
        while (!isGameComplete()) {
            val totalDiceValue: Int = getTotalValueAfterDiceRolls()
            val currentPlayer: Player = players.poll()
            movePlayer(currentPlayer, totalDiceValue)
            if (hasPlayerWon(currentPlayer)) {
                println("${currentPlayer.name} won the game")
                board.playerPieces -= listOf(currentPlayer.id)
            } else
                players.add(currentPlayer)
        }
    }
}
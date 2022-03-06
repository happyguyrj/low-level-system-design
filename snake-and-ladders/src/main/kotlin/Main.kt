import com.example.snakeAndLadders.domain.Ladder
import com.example.snakeAndLadders.domain.Player
import com.example.snakeAndLadders.domain.Snake
import com.example.snakeAndLadders.service.SnakeAndLadderService
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    println("Enter number of snakes:")
    val noOfSnakes = scanner.nextInt()
    val snakes: MutableList<Snake> = ArrayList()

    for (i in 0 until noOfSnakes) {
        println("Enter start and end position of snake $i")
        snakes.add(Snake(scanner.nextInt(), scanner.nextInt()))
    }

    println("Enter number of ladders:")
    val noOfLadders = scanner.nextInt()
    val ladders: MutableList<Ladder> = ArrayList()
    for (i in 0 until noOfLadders) {
        println("Enter start and end position of ladder $i")
        ladders.add(Ladder(scanner.nextInt(), scanner.nextInt()))
    }

    println("Enter number of players:")
    val noOfPlayers = scanner.nextInt()
    val players: MutableList<Player> = ArrayList()
    for (i in 0 until noOfPlayers) {
        println("Enter name of player $i")
        players.add(Player(scanner.next()))
    }

    val snakeAndLadderService = SnakeAndLadderService(100)
    snakeAndLadderService.setPlayers(players)
    snakeAndLadderService.setSnakes(snakes)
    snakeAndLadderService.setLadders(ladders)
    snakeAndLadderService.startGame()
}

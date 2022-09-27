import scala.io.StdIn.readLine
import game.Players
import patterns.Patterns as pm

@main def gooseGame() =
    println(
    """
    #######################################
        Welcome to the Goose Game Kata.
    #######################################
    """
    )

    runGame()

    println(
    """
    #######################################
            Thank you for playing.
    #######################################
    """
    )

def runGame() =
    var running = true
    var players = new Players()

    while
      running
    do
      print("ScalaGooseGame$> ")

      var cmd: String = readLine()

      cmd match
        case pm.addPlayerPattern(name) => players.addPlayer(name)
        case pm.playerRollPattern(name, dice1, dice2) => running = players.movePlayer(name, Some(dice1.toInt), Some(dice2.toInt))
        case pm.gameRollPattern(name) => running = players.movePlayer(name, None, None)
        case pm.endGame() => running = false
        case _ => println("Unknown Command.")

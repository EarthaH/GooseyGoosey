import scala.io.StdIn.readLine
import scala.util.matching.Regex
import scala.util.Random
import scala.collection.mutable.Map
import board.Board as board


var players = Map[String, Int]()

/* Command Patterns */
val addPlayerPattern = """^add\sPlayer\s(\w+)$""".r
val playerRollPattern = """^move\s(\w+)\s([1-6]),\s([1-6])$""".r
val gameRollPattern = """^move\s(\w+)$""".r
val endGame = """^exit$""".r
val rand = Random()


@main def gooseGame() =
    println("Welcome to the Goose Game Kata.")

    var running = true

    while
      running
    do
      running = runGame()

    println("Thank you for playing.")

def runGame(): Boolean =
    print("ScalaGooseGame$> ")

    var cmd: String = readLine()

    cmd match
      case addPlayerPattern(name) => addPlayer(name)
      case playerRollPattern(name, dice1, dice2) => return movePlayer(name, Some(dice1.toInt), Some(dice2.toInt))
      case gameRollPattern(name) => return movePlayer(name, None, None)
      case endGame() => return false
      case _ => println("Unknown Command.")

    return true

def addPlayer(name: String) =
    if players.contains(name) then
      println(s"$name: already existing player")
    else
      players += (name -> 0)
      val names = players.keys
      println(s"players: ${names.mkString(", ")}")

def movePlayer(name: String, dice1: Option[Int], dice2: Option[Int]): Boolean =
    val d1 = board.roll(dice1)
    val d2 = board.roll(dice2)
    var placeOption = players.get(name)
    var continue = true

    placeOption match
      case Some(place) =>
        var newplace = board.getNewPlace(name, place, d1, d2)
        continue = if newplace == 63 then false else true
        players(name) = newplace
      case None =>
        println(s"Could not find player named \"$name\". Try adding the player to the game using the command \"add Player $name\".")

    return continue


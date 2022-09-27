package game

import scala.collection.mutable.Map
import game.Board as board

class Players:
    private var playerMap = Map[String, Int]()

    def addPlayer(name: String) =
        if playerMap.contains(name) then
            println(s"$name: already existing player")
        else
            addPlayerToMap(name)
            println(s"players: ${playerMap.keys.mkString(", ")}")

    def movePlayer(name: String, dice1: Option[Int], dice2: Option[Int]): Boolean =
        val d1 = board.roll(dice1)
        val d2 = board.roll(dice2)
        var continue = true
        var newplace = 0

        var place = getPlayerPlace(name)

        if place >= 0 then
            newplace = board.getNewPlace(name, place, d1, d2)
            continue = if newplace == 63 then false else true
            updatePlayerInMap(name, newplace)

        return continue

    def getPlayers(): Map[String, Int] =
        return playerMap

    private def getPlayerPlace(name: String): Int =
        val placeOption = playerMap.get(name)

        placeOption match
            case Some(place) => return place
            case None => return -1

    private def addPlayerToMap(name: String) =
        val startplace = 0
        playerMap += (name -> startplace)

    private def updatePlayerInMap(name: String, newplace: Int) =
        playerMap(name) = newplace
    
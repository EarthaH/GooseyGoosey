package game

import scala.util.Random

object Board:
    val rand = Random()

    def getNewPlace(name: String, place: Int, dice1: Int, dice2: Int): Int =
        var newplace = place + dice1 + dice2
        var message = s"$name rolls $dice1, $dice2."

        newplace match
            case 63 =>
                message = s"$message $name moves from $place to $newplace. $name Wins!!"
            case x if x > 63 =>
                newplace = 63 - (newplace - 63)
                message = s"$message $name moves from $place to 63. $name bounces! $name returns to $newplace"
            case x if x == 6 =>
                newplace = 12
                message = s"$message $name moves from $place to The Bridge. $name jumps to $newplace"
            case x if x == 5 || x == 9 || x == 14 || x == 18 || x == 23 || x == 27 =>
                message = s"$message $name moves from $place to $newplace"
                while
                newplace == 5 || newplace == 9 || newplace == 14 || newplace == 18 || newplace == 23 || newplace == 27
                do
                newplace += dice1 + dice2
                message = s"$message, The Goose. $name moves again and goes to $newplace"
            case _ =>
                message = s"$message $name moves from $place to $newplace"

        println(message)
        return newplace

    def roll(x: Option[Int]) = x match
        case Some(num) => num
        case None => rand.between(1, 7)
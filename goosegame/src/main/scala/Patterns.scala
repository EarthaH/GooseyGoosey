package patterns

import scala.util.matching.Regex

object Patterns:
    val addPlayerPattern = """^add\sPlayer\s(\w+)$""".r
    val playerRollPattern = """^move\s(\w+)\s([1-6]),\s([1-6])$""".r
    val gameRollPattern = """^move\s(\w+)$""".r
    val endGame = """^exit$""".r

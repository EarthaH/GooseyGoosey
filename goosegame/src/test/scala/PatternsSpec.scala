import patterns.Patterns as pm

class PatternsSpec extends munit.FunSuite {
    val testName = "Bob"
    val testDice1 = 5
    val testDice2 = 1

    test("add: matches and gets player name") {
        val testcommand = s"add Player $testName"

        testcommand match
            case pm.addPlayerPattern(name) =>
                assertEquals(name, testName)
            case _ =>
                fail("Pattern should match.")
    }

    test("move: matches and gets player name, dice rolls") {
        val testcommand = s"move $testName $testDice1, $testDice2"

        testcommand match
            case pm.playerRollPattern(name, dice1, dice2) =>
                assertEquals(name, testName)
                assertEquals(dice1.toInt, testDice1)
                assertEquals(dice2.toInt, testDice2)
            case _ =>
                fail("Pattern should match.")
    }

    test("move: fails due to numbers out of range") {
        val testcommand = s"move $testName 7, 0"

        testcommand match
            case pm.playerRollPattern(name, dice1, dice2) =>
                fail("Pattern should not match.")
            case _ =>
    }

    test("move: matches and gets player name") {
        val testcommand = s"move $testName"

        testcommand match
            case pm.gameRollPattern(name) =>
                assertEquals(name, testName)
            case _ =>
                fail("Pattern should match.")
    }
}
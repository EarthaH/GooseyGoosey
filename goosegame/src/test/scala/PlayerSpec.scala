import game.Players

class AddPlayerSpec extends munit.FunSuite {
    val testName = "Bob"

    test("adds new player to map of players") {
        val players = new Players()

        players.addPlayer(testName)
        val playerMap = players.getPlayers()

        assert(playerMap.contains(testName))
    }

    test("duplicate player does not get added") {
        val players = new Players()

        players.addPlayer(testName)
        players.addPlayer(testName)
        val playerMap = players.getPlayers()

        assertEquals(playerMap.size, 1)
    }
}

class MovePlayerSpec extends munit.FunSuite {
    val testName = "Bob"

    test("moves player to new places with given numbers") {
        val players = new Players()
        players.addPlayer(testName)

        assert(players.movePlayer(testName, Some(1), Some(1)))
    }

    test("moves player to random place") {
        val players = new Players()
        players.addPlayer(testName)

        assert(players.movePlayer(testName, None, None))
    }

    test("discontinues game when places 63") {
        val players = new Players()
        players.addPlayer(testName)

        assert(!players.movePlayer(testName, Some(30), Some(33)))
    }
}
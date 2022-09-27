// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
import board.Board as board

class DiceSuite extends munit.FunSuite {
  test("returns given option[int] as int") {
    val result = board.roll(Some(5))
    val expected = 5

    assertEquals(result, expected)
  }

  test("returns random number between 1 and 6") {
    val result = board.roll(None)

    assert(result > 0)
    assert(result < 7)
  }
}

class PlaceSuite extends munit.FunSuite {
  val testName = "Bob"

  test("win: returns newplace as 63") {
    val result = board.getNewPlace(testName, 60, 1, 2)
    val expected = 63

    assertEquals(result, expected)
  }

  test("bounce: returns newplace as 61") {
    val result = board.getNewPlace(testName, 60, 3, 2)
    val expected = 61

    assertEquals(result, expected)
  }

  test("bridge: returns newplace as 12") {
    val result = board.getNewPlace(testName, 3, 2, 1)
    val expected = 12

    assertEquals(result, expected)
  }

  test("single jump: returns newplace as 7") {
    val result = board.getNewPlace(testName, 3, 1, 1)
    val expected = 7

    assertEquals(result, expected)
  }

  test("double jump: returns newplace as 22") {
    val result = board.getNewPlace(testName, 10, 2, 2)
    val expected = 22

    assertEquals(result, expected)
  }

  test("normal: returns newplace as 50") {
    val result = board.getNewPlace(testName, 40, 5, 5)
    val expected = 50

    assertEquals(result, expected)
  }
}

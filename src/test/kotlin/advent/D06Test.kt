package advent

import org.junit.jupiter.api.Test
import java.io.File

class D06Test {

    @Test
    fun solve1() {
        val input = File("src/main/resources/D06P01.txt").readLines()
        println(D06().solvePart1(input))
    }
}
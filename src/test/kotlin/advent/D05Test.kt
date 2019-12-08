package advent

import org.junit.jupiter.api.Test
import java.io.File

class D05Test {
    @Test
    fun solve1() {
        val input = File("src/main/resources/D05P01.txt").readText()
        println(D05(input.split(",")).solvePart1())
    }

    @Test
    fun solve2() {
        val input = File("src/main/resources/D05P01.txt").readText()
        println(D05(input.split(",")).solvePart2())
    }
}
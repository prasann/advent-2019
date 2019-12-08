package advent

import org.junit.jupiter.api.Test
import java.io.File

class D02Test {
    @Test
    fun part1() {
        val content = File("src/main/resources/D02P01.txt").readText()
        print(D02(content.split(",")).part1())
    }

    @Test
    fun part2() {
        val content = File("src/main/resources/D02P01.txt").readText()
        println(D02(content.split(",")).part2())
    }
}
package advent

import org.junit.jupiter.api.Test

class D01Test {
    @Test
    fun part1() {
        println(D01().calculate("src/main/resources/D01P01.txt"))
    }

    @Test
    fun part2() {
        println(D01().calculateExtension("src/main/resources/D01P01.txt"))
    }
}
package advent

import java.io.File
import kotlin.math.floor

class D01 {
    private fun operation(num: Double): Double {
        return floor((num / 3)) - 2
    }

    fun main(): Double {
        var sum = 0.0
        File("src/main/resources/D01.txt").forEachLine {
            sum += operation(it.toDouble())
        }
        return sum
    }
}
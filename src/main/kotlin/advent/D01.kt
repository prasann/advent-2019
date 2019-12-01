package advent

import java.io.File
import kotlin.math.floor

class D01 {
    private fun op(num: Double): Double {
        if (num <= 0) {
            throw error("Negative")
        }
        return floor((num / 3)) - 2
    }

    fun calculate(inputFilePath: String): Double {
        var sum = 0.0
        File(inputFilePath).forEachLine {
            sum += op(it.toDouble())
        }
        return sum
    }

    fun calculateExtension(inputFilePath: String): Double {
        var sum = 0.0
        File(inputFilePath).forEachLine {
            sum += extendedOp(it.toDouble())
        }
        return sum
    }

    private fun extendedOp(initNum: Double, result: Double = 0.0): Double {
        if (initNum <= 0.0) {
            return result
        }
        val singleOpResult = op(initNum)
        if (singleOpResult <= 0) {
            return result
        }
        return extendedOp(singleOpResult, result + singleOpResult)
    }
}
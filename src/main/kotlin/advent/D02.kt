package advent

import java.io.File

class D02 {
    fun readData(inputPath: String): Array<Int> {
        val fileContent = File(inputPath).readText()
        return fileContent.split(",").map { it.toInt() }.toTypedArray()
    }

    fun calculate(inputArray: Array<Int>, noun: Int = 12, verb: Int = 2): Int {
        inputArray[1] = noun
        inputArray[2] = verb
        var done = false
        var index = 0
        while (index < inputArray.size && !done) {
            when (inputArray[index]) {
                1 -> add(inputArray, index)
                2 -> multiply(inputArray, index)
                99 -> done = true
                else -> throw RuntimeException("Not allowed")
            }
            index += 4
        }
        return inputArray[0]
    }

    fun part1(inputfilePath: String): Int {
        return calculate(readData(inputfilePath))
    }

    fun part2(inputPath: String): Int {
        for (n in 0..99) {
            for (v in 0..99) {
                if (calculate(readData(inputPath), n, v) == 19690720) {
                    return 100 * n + v
                }
            }
        }
        return 0
    }

    private fun add(inputArray: Array<Int>, index: Int) {
        inputArray[inputArray[index + 3]] = inputArray[inputArray[index + 1]] + inputArray[inputArray[index + 2]]
    }

    private fun multiply(inputArray: Array<Int>, index: Int) {
        inputArray[inputArray[index + 3]] = inputArray[inputArray[index + 1]] * inputArray[inputArray[index + 2]]
    }
}
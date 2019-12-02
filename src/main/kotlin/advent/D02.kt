package advent

import java.io.File
import java.lang.RuntimeException

class D02 {
    fun calculate(inputPath: String) {
        val fileContent = File(inputPath).readText()
        var inputArray = fileContent.split(",").map { it.toInt() }.toTypedArray()
        var done  = false
        var index = 0
        while (index < inputArray.size && !done) {
            when (inputArray[index]) {
                1 -> {
                    add(inputArray, index)
                    index += 4
                }
                2 ->  {
                    multiply(inputArray, index)
                    index += 4
                }
                99 -> {
                    halt(inputArray)
                    done = true
                }
                else -> throw RuntimeException("Not allowed")
            }
        }
    }

    private fun add(inputArray: Array<Int>, index: Int) {
        inputArray[inputArray[index + 3]] = inputArray[inputArray[index + 1]] + inputArray[inputArray[index + 2]]
    }

    private fun multiply(inputArray: Array<Int>, index: Int) {
        inputArray[inputArray[index + 3]] = inputArray[inputArray[index + 1]] * inputArray[inputArray[index + 2]]
    }

    private fun halt(inputArray: Array<Int>) {
        println(inputArray.joinToString(","))
    }
}
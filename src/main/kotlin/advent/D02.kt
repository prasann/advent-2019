package advent

class D02(input: List<String>) {

    private val parsedInput = input.map { it.toInt() }.toMutableList()

    fun part1(): Int {
        val computer = Intcode(parsedInput)
        computer.reinitialize(listOf(Pair(1, 12), Pair(2, 2)))
        computer.run()
        return computer.dumpMemory()[0]
    }

    fun part2(): Int {
        val desired = 19690720
        val computer = Intcode(parsedInput)
        for (noun in 0 until 99) {
            for (verb in 0 until 99) {
                computer.reinitialize(listOf(Pair(1, noun), Pair(2, verb)))
                computer.run()
                if (computer.dumpMemory()[0] == desired) {
                    return 100 * noun + verb
                }
            }
        }
        return -1
    }
}
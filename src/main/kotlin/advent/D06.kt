package advent

class D06(input: List<String>) {
    private tailrec fun Map<String, String>.orbitChain(body: String, chain: List<String> = emptyList()): List<String> =
        if (containsKey(body)) orbitChain(getValue(body), chain + body) else chain

    private val orbitMap = input.map { it.split(')') }.map { it[1] to it[0] }.toMap()

    fun solvePart1(): Int {
        return orbitMap.keys.map { orbitMap.orbitChain(it).size }.sum()
    }

    fun solvePart2(): Int {
        val youMap = orbitMap.orbitChain("YOU").reversed()
        val santaMap = orbitMap.orbitChain("SAN").reversed()

        val commonLength = youMap.indices.takeWhile {
            youMap[it] == santaMap[it]
        }.size

        return youMap.size + santaMap.size - commonLength * 2 - 2
    }
}
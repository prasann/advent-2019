package advent

class D06 {
    private tailrec fun count(value: String, dataMap: Map<String, String>, orbits: Int = 1): Int {
        if (value == "COM") return orbits
        return count(dataMap.getValue(value), dataMap, orbits + 1)
    }

    fun solvePart1(input: List<String>): Int {
        val orbitMap = input.map { it.split(')') }.map { it[1] to it[0] }.toMap()
        return orbitMap.map { count(it.value, orbitMap) }.sum()
    }
}
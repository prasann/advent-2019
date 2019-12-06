package advent

class D04 {
    fun Int.isAscending(): Boolean {
        val num = this.toString()
        val number = num.toCharArray().map { Integer.parseInt(it.toString()) }
        return number.sorted().joinToString("") == num
    }

    fun Int.frequency(): Collection<Int> {
        return toString().groupingBy { it }.eachCount().values
    }

    fun Int.hasADouble(): Boolean {
        return (frequency().max() ?: 0) >= 2
    }

    fun Int.hasADoubleOnly(): Boolean {
        return frequency().contains(2)
    }

    fun part1(start: Int, end: Int): Int {
        return (start..end).filter { it.isAscending() && it.hasADouble() }.size
    }

    fun part2(start: Int, end: Int): Int {
        return (start..end).filter { it.isAscending() && it.hasADoubleOnly() }.size
    }
}
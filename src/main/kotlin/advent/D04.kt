package advent

class D04 {
    fun Int.isAscending(): Boolean {
        val num = this.toString()
        val number = num.toCharArray().map { Integer.parseInt(it.toString()) }
        return number.sorted().joinToString("") == num
    }

    fun Int.hasADouble(): Boolean {
        return Regex("(.)\\1+").containsMatchIn(toString())
    }

    fun Int.hasADoubleOnly(): Boolean {
        val num = toString()
        return num.groupingBy { it }.eachCount().values.contains(2)
    }

    fun part1(start: Int, end: Int): Int {
        return (start..end).filter { it.isAscending() && it.hasADouble() }.size
    }

    fun part2(start: Int, end: Int): Int {
        return (start..end).filter { it.isAscending() && it.hasADoubleOnly() }.size
    }
}
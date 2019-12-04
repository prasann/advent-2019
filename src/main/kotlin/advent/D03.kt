package advent

import kotlin.math.abs

class D03 {
    fun generateSeq(x1: Int, y1: Int, x2: Int, y2: Int): List<String> {

        return if (x1 != x2) {
            if (x1 < x2) (x1..x2).map { "$it,$y1" } else (x1 downTo x2).map { "$it,$y1" }
        } else {
            if (y1 < y2) (y1..y2).map { "$x1,$it" } else (y1 downTo y2).map { "$x1,$it" }
        }
    }

    fun parse(wirePath: String): List<String> {
        val result = mutableListOf<String>()
        var (x, y) = arrayOf(0, 0)
        wirePath.split(",").map {
            var count = it.removeRange(0..0)
            when (it[0]) {
                'U' -> {
                    result.addAll(generateSeq(x, y, x, y + Integer.parseInt(count)))
                    y += Integer.parseInt(count)
                }
                'R' -> {
                    result.addAll(generateSeq(x, y, x + Integer.parseInt(count), y))
                    x += Integer.parseInt(count)
                }
                'D' -> {
                    result.addAll(generateSeq(x, y, x, y - Integer.parseInt(count)))
                    y -= Integer.parseInt(count)
                }
                'L' -> {
                    result.addAll(generateSeq(x, y, x - Integer.parseInt(count), y))
                    x -= Integer.parseInt(count)
                }
                else -> throw RuntimeException("Not allowed")
            }
        }
        return result
    }


    fun compute(wirePath1: String, wirePath2: String): Int {
        println("Started !!")
        val wire1Nodes = parse(wirePath1)
        println("Done listing all nodes for path1")
        val wire2Nodes = parse(wirePath2)
        println("Done listing all nodes for path2")

        val distance = mutableListOf<Int>()
        wire1Nodes.forEach {
            val indexOf = wire2Nodes.indexOf(it)
            if (indexOf != -1 && indexOf != 0) {
                val (x, y) = it.split(",").map { num -> Integer.parseInt(num) }
                distance.add(abs(x) + abs(y))
            }
        }
        distance.sort()
        return distance[0]
    }
}
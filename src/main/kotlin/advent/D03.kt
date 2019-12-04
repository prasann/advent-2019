package advent

import kotlin.math.abs

class D03 {
    fun generateSeq(x1: Int, y1: Int, x2: Int, y2: Int): List<String> {
        return if (x1 != x2) {
            if (x1 < x2) (x1 + 1..x2).map { "$it,$y1" } else (x1 - 1 downTo x2).map { "$it,$y1" }
        } else {
            if (y1 < y2) (y1 + 1..y2).map { "$x1,$it" } else (y1 - 1 downTo y2).map { "$x1,$it" }
        }
    }

    fun parse(wirePath: String): List<String> {
        val result = mutableListOf<String>("0,0")
        var (x, y) = arrayOf(0, 0)
        wirePath.split(",").map {
            val count = it.removeRange(0..0)
            val stepCounter = Integer.parseInt(count)
            when (it[0]) {
                'U' -> {
                    result.addAll(generateSeq(x, y, x, y + stepCounter))
                    y += stepCounter
                }
                'R' -> {
                    result.addAll(generateSeq(x, y, x + stepCounter, y))
                    x += stepCounter
                }
                'D' -> {
                    result.addAll(generateSeq(x, y, x, y - stepCounter))
                    y -= stepCounter
                }
                'L' -> {
                    result.addAll(generateSeq(x, y, x - stepCounter, y))
                    x -= stepCounter
                }
                else -> throw RuntimeException("Not allowed")
            }
        }
        return result
    }


    fun compute(wirePath1: String, wirePath2: String): Map<String, Int> {
        val wire1Nodes = parse(wirePath1)
        val wire2Nodes = parse(wirePath2)

        val distance = mutableListOf<Int>()
        val steps = mutableListOf<Int>()
        wire1Nodes.forEachIndexed { in1, item ->
            val in2 = wire2Nodes.indexOf(item)
            if (in2 != -1 && in2 != 0) {
                steps.add(in1 + in2)
                val (x, y) = item.split(",").map { num -> Integer.parseInt(num) }
                distance.add(abs(x) + abs(y))
            }
        }
        distance.sort()
        steps.sort()
        return mapOf("distance" to distance[0], "steps" to steps[0])
    }
}
package day4

import java.io.File

fun main() {
    val countOfRangesIncluding = File("src/main/resources/day4.txt").readLines()
        .map(::getRange)
        .count(::includes)

    println("Count of ranges including one another is $countOfRangesIncluding")
}

fun getRange(s: String): Pair<IntRange, IntRange> {
    val ranges = s.split(" ").map(String::toInt)

    val range1 = ranges[0]..ranges[1]
    val range2 = ranges[2]..ranges[3]

    return Pair(range1, range2)
}

fun includes(input: Pair<IntRange, IntRange>): Boolean {
    val (r1, r2) = input

    return when {
        r1.first in r2 && r1.last in r2 -> true
        r2.first in r1 && r2.last in r1 -> true
        else -> false
    }
}

package day4

import java.io.File

fun main() {
    val countOfRangesOverlapping = File("src/main/resources/day4.txt").readLines()
        .map(::getRange)
        .count(::overlap)

    println("Count of ranges that overlap is $countOfRangesOverlapping")
}

fun overlap(input: Pair<IntRange, IntRange>): Boolean =
    input.first.intersect(input.second).isNotEmpty()

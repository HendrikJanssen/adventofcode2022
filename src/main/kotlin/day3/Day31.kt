package day3

import java.io.File

fun main() {
    val prioritySum = File("src/main/resources/day3.txt").readLines()
        .chunked(3)
        .map(::findCharContainedInAll)
        .map(::getPriority)
        .sum()

    println("Sum of all priorities is $prioritySum")
}

fun findCharContainedInAll(rucksacks: List<String>): Char {
    for (char in rucksacks[0]) {
        if (rucksacks[1].contains(char) && rucksacks[2].contains(char)) {
            return char
        }
    }

    throw IllegalStateException()
}

package day3

import java.io.File

fun main() {
    val prioritySum = File("src/main/resources/day3.txt").readLines()
        .map(::splitString)
        .map { (l, r) -> findDuplicateItemItem(l, r) }
        .map(::getPriority)
        .sum()

    println("Sum of all priorities is $prioritySum")
}

fun splitString(input: String): Pair<String, String> {
    val splitIndex = input.length / 2

    val left = input.substring(0, splitIndex)
    val right = input.substring(splitIndex)

    return Pair(left, right)
}

fun findDuplicateItemItem(left: String, right: String): Char {
    for (char in left) {
        if (right.contains(char)) {
            return char
        }
    }

    throw IllegalStateException()
}

fun getPriority(char: Char): Int = if (char.isLowerCase()) {
    char.code - (97 - 1)
} else {
    char.code - (65 - 1) + 26
}

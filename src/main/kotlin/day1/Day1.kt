package day1

import java.io.File

fun main() {
    val lines = File("src/main/resources/day1.txt").readLines()
    val elves = mutableListOf<Int>()
    var elve = 0

    for (line in lines) {
        if (line.isBlank()) {
            elves.add(elve)
            elve = 0
        } else {
            elve += line.toInt()
        }
    }

    val highest = elves.max()

    elves.sortDescending()
    val highestThree = elves.slice(0..2).sum()

    println("Elve with highest calory count has $highest calories. Top 3 have $highestThree calories in total")
}

package day2

import java.io.File

enum class Shape {
    ROCK,
    PAPER,
    SCISSORS
}

fun Shape.beats(): Shape = when (this) {
    Shape.ROCK -> Shape.SCISSORS
    Shape.PAPER -> Shape.ROCK
    Shape.SCISSORS -> Shape.PAPER
}

fun main() {
    val plays = File("src/main/resources/day2.txt").readLines().map {
        val opponent = when (it[0]) {
            'A' -> Shape.ROCK
            'B' -> Shape.PAPER
            'C' -> Shape.SCISSORS
            else -> throw IllegalStateException()
        }

        val you = when (it[2]) {
            'X' -> Shape.ROCK
            'Y' -> Shape.PAPER
            'Z' -> Shape.SCISSORS
            else -> throw IllegalStateException()
        }

        Pair(opponent, you)
    }

    var score = 0
    for (round in plays) {
        score += scoreForRound(round.first, round.second)

        score += when(round.second) {
            Shape.ROCK -> 1
            Shape.PAPER -> 2
            Shape.SCISSORS -> 3
        }
    }

    println("For ${plays.size} rounds, you got a score of $score")
}

fun scoreForRound(opponent: Shape, you: Shape): Int {
    if (opponent == you) {
        return 3 // draw
    }

    return if (you.beats() == opponent) {
        6
    } else {
        0
    }
}

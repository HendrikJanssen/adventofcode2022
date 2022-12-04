package day21

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

fun Shape.score(): Int = when (this) {
    Shape.ROCK -> 1
    Shape.PAPER -> 2
    Shape.SCISSORS -> 3
}

enum class Outcome {
    LOSE,
    DRAW,
    WIN
}

fun Outcome.toScore(): Int = when (this) {
    Outcome.WIN -> 6
    Outcome.DRAW -> 3
    Outcome.LOSE -> 0
}

fun main() {
    val plays = File("src/main/resources/day2.txt").readLines().map {
        val opponent = when (it[0]) {
            'A' -> Shape.ROCK
            'B' -> Shape.PAPER
            'C' -> Shape.SCISSORS
            else -> throw IllegalStateException()
        }

        val outcome = when (it[2]) {
            'X' -> Outcome.LOSE
            'Y' -> Outcome.DRAW
            'Z' -> Outcome.WIN
            else -> throw IllegalStateException()
        }

        Pair(opponent, outcome)
    }

    var score = 0
    for ((opponent, outcome) in plays) {
        score += outcome.toScore()

        score += getRequiredShapeForOutcome(opponent, outcome).score()
    }

    println("For ${plays.size} rounds, you got a score of $score")
}

fun getRequiredShapeForOutcome(opponent: Shape, outcome: Outcome): Shape = when (outcome) {
    Outcome.DRAW -> opponent
    Outcome.LOSE -> Shape.values().find { opponent.beats() == it }!!
    Outcome.WIN -> Shape.values().find { it.beats() == opponent }!!
}


package day2

import java.io.File

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


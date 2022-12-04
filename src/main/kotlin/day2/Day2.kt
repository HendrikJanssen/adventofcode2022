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

        val you = when (it[2]) {
            'X' -> Shape.ROCK
            'Y' -> Shape.PAPER
            'Z' -> Shape.SCISSORS
            else -> throw IllegalStateException()
        }

        Pair(opponent, you)
    }

    var score = 0
    for ((opponent, you) in plays) {
        score += calcOutcome(opponent, you).toScore()

        score += you.score()
    }

    println("For ${plays.size} rounds, you got a score of $score")
}

fun calcOutcome(opponent: Shape, you: Shape): Outcome = when (opponent) {
    you -> Outcome.DRAW
    you.beats() -> Outcome.WIN
    else -> Outcome.LOSE
}

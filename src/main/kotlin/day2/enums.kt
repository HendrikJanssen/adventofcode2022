package day2

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

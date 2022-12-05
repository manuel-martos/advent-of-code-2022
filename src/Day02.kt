fun main() {
    println("part01 -> ${solveDay02Part01()}")
    println("part02 -> ${solveDay02Part02()}")
}

private fun solveDay02Part01() =
    readInput("day02")
        .sumOf {
            val other = it[0] - 'A' + 1
            val mine = it[2] - 'X' + 1
            val outcome = calcOutcome(mine, other)
            mine + outcome
        }

private fun solveDay02Part02() =
    readInput("day02")
        .sumOf {
            val other = it[0] - 'A' + 1
            val goal = it[2] - 'X' + 1
            val mine = when {
                other == 1 && goal == 1 -> 3
                other == 2 && goal == 1 -> 1
                other == 3 && goal == 1 -> 2
                other == 1 && goal == 3 -> 2
                other == 2 && goal == 3 -> 3
                other == 3 && goal == 3 -> 1
                else -> other
            }
            val outcome = calcOutcome(mine, other)
            mine + outcome
        }

private fun calcOutcome(mine: Int, other: Int) =
    when {
        other == 1 && mine == 2 -> 6
        other == 2 && mine == 3 -> 6
        other == 3 && mine == 1 -> 6
        other == mine -> 3
        else -> 0
    }
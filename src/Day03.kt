fun main() {
    println("part01 -> ${solveDay03Part01()}")
    println("part02 -> ${solveDay03Part02()}")
}

private fun solveDay03Part01() =
    readInput("day03")
        .sumOf { line ->
            val half1 = line.substring(0 until line.length / 2).toSet()
            val half2 = line.substring(line.length / 2 until line.length).toSet()
            val result = half1.intersect(half2)
            result.sumOf { it.priority() }
        }

private fun solveDay03Part02() =
    readInput("day03")
        .chunked(3)
        .sumOf {
            it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet()).sumOf(Char::priority)
        }


private fun Char.priority(): Int =
    if (isLowerCase()) {
        this - 'a' + 1
    } else {
        this - 'A' + 27
    }


fun main() {
    println("part01 -> ${solveDay01Part01()}")
    println("part02 -> ${solveDay01Part02()}")
}

private fun solveDay01Part01(): Int =
    parser().max()

private fun solveDay01Part02(): Int =
    parser()
        .sortedDescending()
        .run { get(0) + get(1) + get(2) }

private fun parser(): List<Int> {
    val result = mutableListOf<Int>()
    result.add(0)
    readInput("day01").forEach {
        if (it.isEmpty()) {
            result.add(0)
        } else {
            result[result.size - 1] = result.last() + it.toInt()
        }
    }
    return result
}

fun main() {
    println("part01 -> ${solveDay01Part01()}")
    println("part02 -> ${solveDay01Part02()}")
}

private fun solveDay01Part01(): Int {
    val result = mutableListOf<Int>()
    result.add(0)
    readInput("day01").forEach {
        if (it.isEmpty()) {
            result.add(0)
        } else {
            result.set(result.size - 1, result.last() + it.toInt())
        }
    }
    return result.max()
}

private fun solveDay01Part02(): Int {
    val result = mutableListOf<Int>()
    result.add(0)
    readInput("day01").forEach {
        if (it.isEmpty()) {
            result.add(0)
        } else {
            result.set(result.size - 1, result.last() + it.toInt())
        }
    }
    result.sortDescending()
    return result[0] + result[1] + result[2]
}

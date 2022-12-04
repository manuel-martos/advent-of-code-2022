fun main() {
    println("part01 -> ${solveDay04Part01()}")
    println("part02 -> ${solveDay04Part02()}")
}

fun solveDay04Part01() =
    solver { range1, range2 ->
        if ((range1.contains(range2.first) && range1.contains(range2.last)) ||
            (range2.contains(range1.first) && range2.contains(range1.last))
        ) {
            1
        } else {
            0
        }
    }

fun solveDay04Part02() =
    solver { range1, range2 ->
        if (range1.contains(range2.first) ||
            range1.contains(range2.last) ||
            range2.contains(range1.first) ||
            range2.contains(range1.last)
        ) {
            1
        } else {
            0
        }
    }

fun solver(reducer: (IntRange, IntRange) -> Int) =
    readInput("day04")
        .map { it.split(",", "-") }
        .sumOf {
            val range1 = it[0].toInt()..it[1].toInt()
            val range2 = it[2].toInt()..it[3].toInt()
            reducer(range1, range2)
        }

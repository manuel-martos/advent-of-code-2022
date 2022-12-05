import java.util.*

fun main() {
    println("part01 -> ${solveDay05Part01()}")
    println("part02 -> ${solveDay05Part02()}")
}

private fun solveDay05Part01(): String {
    val input = readInput("day05")
    val index = input.indexOf("")
    val stacks = input.subList(0, index)
    val movements = input.subList(index + 1, input.size)
    val parsedStacks = parseStacks(stacks)
    val parsedMovements = parseMovements(movements)
    applyMovements(parsedStacks, parsedMovements)
    return parsedStacks.keys.sorted().joinToString(separator = "") {
        parsedStacks[it]!!.first().toString()
    }
}

private fun solveDay05Part02(): String {
    val input = readInput("day05")
    val index = input.indexOf("")
    val stacks = input.subList(0, index)
    val movements = input.subList(index + 1, input.size)
    val parsedStacks = parseStacks(stacks)
    val parsedMovements = parseMovements(movements)
    applyMultipleMovements(parsedStacks, parsedMovements)
    return parsedStacks.keys.sorted().joinToString(separator = "") {
        parsedStacks[it]!!.first().toString()
    }
}

private fun parseStacks(stackConfig: List<String>): Map<Int, LinkedList<Char>> {
    val stackIds = stackConfig
        .last()
        .split(" ")
        .map { try { it.toInt() } catch (e: Throwable) { "" } }
        .filterIsInstance<Int>()

    val result = stackIds.associateWith { LinkedList<Char>() }
    val items = stackConfig.reversed().subList(1, stackConfig.size)
    items.forEach {
        for (entry in result.entries) {
            val startIndex = (entry.key - 1) * 4 + 1
            val endIndex = (entry.key - 1) * 4 + 2
            val content = it.substring(startIndex, endIndex)[0]
            if (content.isLetter()) {
                entry.value.push(content)
            }
        }
    }
    return result
}

private fun parseMovements(movements: List<String>): List<Triple<Int, Int, Int>> {
    val regex = """move (\d+) from (\d+) to (\d+)""".toRegex()
    return movements
        .map {
            val groups = regex.find(it)?.groupValues ?:
            error("Nope")
            groups.subList(1, groups.size).map(String::toInt)
        }
        .map { Triple(it[0], it[1], it[2]) }
}

private fun applyMovements(stacks: Map<Int, LinkedList<Char>>, movements: List<Triple<Int, Int, Int>>) {
    movements.forEach {
        val source = it.second
        val target = it.third
        repeat(it.first) {
            stacks[target]!!.push(stacks[source]!!.pop())
        }
    }
}

private fun applyMultipleMovements(stacks: Map<Int, LinkedList<Char>>, movements: List<Triple<Int, Int, Int>>) {
    movements.forEach {
        val source = it.second
        val target = it.third
        val temp = LinkedList<Char>()
        repeat(it.first) {
            temp.push(stacks[source]!!.pop())
        }
        repeat(it.first) {
            stacks[target]!!.push(temp.pop())
        }
    }
}
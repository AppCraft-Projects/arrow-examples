package org.codetome.kotlincode.stdlibexplore.notwellknown.immutable

fun main(args: Array<String>) {

    val listWithDuplicates = listOf(1, 1, 2, 2, 3, 4)

    val distinct = listWithDuplicates.distinct()

    println(distinct)
    // [1, 2, 3, 4]

    val chars = listOf("a", "A", "b", "B", "c")

    val distinctBy = chars.distinctBy { it.toLowerCase() }

    println(distinctBy)
    // [a, b, c]

}

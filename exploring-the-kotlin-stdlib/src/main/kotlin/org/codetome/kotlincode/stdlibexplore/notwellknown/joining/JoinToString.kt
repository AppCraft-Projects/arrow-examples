package org.codetome.kotlincode.stdlibexplore.notwellknown.joining

fun main(args: Array<String>) {

    val numbers = listOf(1, 2, 3, 4)

    // shorthand for creating a string from an iterable

    val joinToString = numbers.joinToString(", ")

    println(joinToString)
    // 1, 2, 3, 4

}

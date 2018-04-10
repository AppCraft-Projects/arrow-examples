package org.codetome.kotlincode.stdlibexplore.notwellknown.joining

fun main(args: Array<String>) {

    val nodes = listOf("A", "B", "C", "D")

    // creates pairs from elements pointing to the next (just like in a graph)

    val zipWithNext = nodes.zipWithNext()

    println(zipWithNext)
    // [(A, B), (B, C), (C, D)]

}

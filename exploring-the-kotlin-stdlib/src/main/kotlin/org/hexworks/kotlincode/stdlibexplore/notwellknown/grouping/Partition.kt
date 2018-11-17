package org.hexworks.kotlincode.stdlibexplore.notwellknown.grouping

fun main(args: Array<String>) {

    val items = listOf(1, 2, 3, 4)

    // groups to a pair of lists based on a predicate

    val partition = items.partition { number ->
        number % 2 == 0
    }

    println(partition)
    // ([2, 4], [1, 3])

}

package org.codetome.kotlincode.stdlibexplore.notwellknown.grouping

fun main(args: Array<String>) {

    val items = listOf(1, 2, 3, 4)

    // groups a list by keys, creating a multimap

    val groupBy = items.groupBy { item -> if (item % 2 == 0) "even" else "odd" }

    println(groupBy)
    // {odd=[1, 3], even=[2, 4]}

}

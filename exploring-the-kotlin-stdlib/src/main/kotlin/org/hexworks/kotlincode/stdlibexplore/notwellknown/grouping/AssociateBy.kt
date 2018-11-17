package org.hexworks.kotlincode.stdlibexplore.notwellknown.grouping

fun main(args: Array<String>) {

    val items = listOf(1, 2, 3, 4)

    // does not transform, just takes a key selector function

    items.associateBy { number ->
        if (number % 2 == 0) "greatest_even" else "greatest_odd"
    }

    // {greatest_odd=3, greatest_even=4}

}

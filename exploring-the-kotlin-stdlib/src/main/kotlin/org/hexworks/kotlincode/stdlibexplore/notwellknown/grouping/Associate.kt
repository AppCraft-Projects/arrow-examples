package org.hexworks.kotlincode.stdlibexplore.notwellknown.grouping

fun main(args: Array<String>) {

    val items = listOf(1, 2, 3, 4)

    // transforms elements, returns only the last if duplicates are found

    items.associate { number ->
        (if (number % 2 == 0) "greatest_even" else "greatest_odd") to number
    }

    // {greatest_odd=3, greatest_even=4}

}

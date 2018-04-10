package org.codetome.kotlincode.stdlibexplore.notwellknown.immutable

fun main(args: Array<String>) {

    val myList = listOf(1, 2, 3, 4, 5, 6)

    val drop = myList.drop(4)

    println(drop)
    // [5, 6]

    val dropLast = myList.dropLast(4)

    println(dropLast)
    // [1, 2]

    val dropWhile = myList.dropWhile { it < 5 }

    println(dropWhile)
    // [5, 6]

    val dropLastWhile = myList.dropLastWhile { it > 3 }

    println(dropLastWhile)
    // [1, 2, 3]

}

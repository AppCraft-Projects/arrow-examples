package org.codetome.kotlincode.stdlibexplore.notwellknown.immutable

fun main(args: Array<String>) {

    val myList = listOf(1, 2, 3, 4, 5, 6)

    val take = myList.take(3)

    println(take)
    // [1, 2, 3]

    val takeLast = myList.takeLast(3)

    println(takeLast)
    // [4, 5, 6]

    val takeWhile = myList.takeWhile { it < 5 }

    println(takeWhile)
    // [1, 2, 3, 4]

    val takeLastWhile  =myList.takeLastWhile { it > 5 }

    println(takeLastWhile)
    // [6]

}

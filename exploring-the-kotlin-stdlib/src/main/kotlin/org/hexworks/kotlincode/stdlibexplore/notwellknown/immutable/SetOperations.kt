package org.hexworks.kotlincode.stdlibexplore.notwellknown.immutable

fun main(args: Array<String>) {

    val mySet = setOf(1, 2, 3, 4, 5, 6)

    val union = mySet.union(setOf(7, 8, 9))

    println(union)
    // [1, 2, 3, 4, 5, 6, 7, 8, 9]

    val intersection = mySet.intersect(setOf(3, 4, 5, 11, 12))

    println(intersection)
    // [3, 4, 5]

    val difference = mySet.subtract(setOf(1, 2, 3))

    println(difference)
    // [4, 5, 6]

}

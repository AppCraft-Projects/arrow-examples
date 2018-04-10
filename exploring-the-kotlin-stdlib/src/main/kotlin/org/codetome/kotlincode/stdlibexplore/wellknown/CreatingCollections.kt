package org.codetome.kotlincode.stdlibexplore.wellknown

fun main(args: Array<String>) {

    val myArray = arrayOf(1, 2, 3)

    val mySet = setOf("foo", "bar", "baz")

    val myMap = mapOf(Pair(1, 2), Pair(2, 3))

    val myList = listOf('x', 'y', 'z')

    val plusList = myList + 'a'

    println(plusList)

    // [x, y, z, a]

    val minusList = myList.minus('x')

    println(minusList)

    // [y, z]
}

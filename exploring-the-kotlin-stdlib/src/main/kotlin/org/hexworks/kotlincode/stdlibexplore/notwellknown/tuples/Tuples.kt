package org.hexworks.kotlincode.stdlibexplore.notwellknown.tuples

fun main(args: Array<String>) {

    Pair("foo", "bar")

    Triple(1, "wom", "bat")

    fun someFunction(): Pair<String, Int> = Pair("foo", 1)

    val (foo, one) = someFunction()

    // foo will be the first, one will be the second value of a Pair

    val oneToThree = 1 to 3
    println(oneToThree)

    // (1, 3)

    val myMap = mapOf(1 to 3, 4 to 2)

    println(myMap)

    // {1=3, 4=2}
}

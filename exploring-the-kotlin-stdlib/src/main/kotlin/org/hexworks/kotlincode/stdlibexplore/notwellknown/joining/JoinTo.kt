package org.hexworks.kotlincode.stdlibexplore.notwellknown.joining

fun main(args: Array<String>) {

    val numbers = listOf(1, 2, 3, 4)

    val stringBuilder = StringBuilder()

    // joins the elements of an iterable to an appendable

    val joinTo = numbers.joinTo(stringBuilder, ", ")

    println(joinTo)
    // 1, 2, 3, 4

}

package org.hexworks.kotlincode.stdlibexplore.notwellknown.joining

fun main(args: Array<String>) {

    val names = listOf("Jon", "John", "Jane")
    val ages = listOf(23, 32, 28)

    // zips two lists into a list of Pairs

    val zip = names.zip(ages)

    println(zip)
    // [(Jon, 23), (John, 32), (Jane, 28)]

}

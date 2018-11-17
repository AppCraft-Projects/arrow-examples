package org.hexworks.kotlincode.stdlibexplore.wellknown

fun main(args: Array<String>) {

    val myList = listOf("John", "Joe", "Kevin", "Leonard", "Maynard")

    val result = myList.map {
        it.toUpperCase() // [JOHN, JOE, KEVIN, LEONARD, MAYNARD]
    }.filter {
        it.startsWith("J") // [JOHN, JOE]
    }.reduce { total, next ->
        "$total, $next"
    }

    println(result) // JOHN, JOE

}

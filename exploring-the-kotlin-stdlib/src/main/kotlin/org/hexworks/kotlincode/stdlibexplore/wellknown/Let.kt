package org.hexworks.kotlincode.stdlibexplore.wellknown

fun main(args: Array<String>) {

    val myString = "foo"

    val myUppercase = myString.let {
        it.toUpperCase()
    }

    val maybeString: String? = null

    val maybeUpperCase = maybeString?.let {
        it.toUpperCase()
    }
}

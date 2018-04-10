package org.codetome.kotlincode.stdlibexplore.wellknown

fun main(args: Array<String>) {

    data class User(var name: String = "unknown", var age: Int = 0)

    User().apply {
        name = "Joe"
        age = 32
    }

}

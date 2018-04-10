package org.codetome.kotlincode.stdlibexplore.pitfalls

fun main(args: Array<String>) {

    val list = listOf("foo.bar", "baz.qux")
    list.forEach {
        it.split(".").forEach {
            println(it) // so which one we print here?
        }
    }

    // solution

    list.forEach { item ->
        item.split(".").forEach { part ->
            println(part)
        }
    }

}

package org.codetome.kotlincode.stdlibexplore.pitfalls

fun main(args: Array<String>) {

    class Foo {
        private val c: String
        init {
            bar() // will throw NPE when called
            c = ""
        }
        private fun bar() {
            println(c.length) // null
        }
    }

}

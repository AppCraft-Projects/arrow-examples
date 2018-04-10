package org.codetome.kotlincode.stdlibexplore.pitfalls

fun main(args: Array<String>) {

    data class Foo(val bars: MutableList<String>)

    val bars = mutableListOf("foobar", "wombar")
    val foo0 = Foo(bars)
    val foo1 = foo0.copy()
    bars.add("oops")

    println(foo1.bars.joinToString())
    // foobar, wombar, oops



}

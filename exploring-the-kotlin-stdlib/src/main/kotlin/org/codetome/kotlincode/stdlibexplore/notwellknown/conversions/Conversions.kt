package org.codetome.kotlincode.stdlibexplore.notwellknown.conversions

fun main(args: Array<String>) {

    val myList = listOf("foo", "bar", "foo", "qux")

    val mySet = myList.toSet()

    println(mySet)
    // [foo, bar, qux]

    val byteArray: ByteArray = listOf<Byte>(1, 2, 3).toByteArray()

    val typedArray: Array<String> = myList.toTypedArray()

}

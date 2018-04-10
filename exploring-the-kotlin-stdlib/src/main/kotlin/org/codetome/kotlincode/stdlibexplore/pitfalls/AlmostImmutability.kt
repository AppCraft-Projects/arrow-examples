package org.codetome.kotlincode.stdlibexplore.pitfalls

fun main(args: Array<String>) {

    val someList = mutableListOf("foo", "bar")

    data class MyClass(
            // supposedly immutable
            val someList: List<String>)

    val instance = MyClass(someList)

    someList.add("baz") // will add it

    println(instance.someList)
    // [foo, bar, baz] <-- BOOM

    // solution:



}

class OtherClass private constructor(
        val someList: List<String>) {

    companion object {

        fun create(someList: List<String>): OtherClass {
            return OtherClass(someList.toList())
        }
    }

}

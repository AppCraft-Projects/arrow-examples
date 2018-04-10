package org.codetome.kotlincode.stdlibexplore.notwellknown.joining

fun main(args: Array<String>) {

    data class User(val name: String, val age: Int)

    val names = listOf("Jon", "John", "Jane")
    val ages = listOf(23, 32, 28)

    // Same as zip but instead of using a Pair you can specify your own result class

    val zip = names.zip(ages, { name, age -> User(name, age)})

    println(zip)
    // [User(name=Jon, age=23), User(name=John, age=32), User(name=Jane, age=28)]

}

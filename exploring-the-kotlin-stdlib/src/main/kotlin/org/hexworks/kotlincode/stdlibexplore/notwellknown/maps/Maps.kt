package org.hexworks.kotlincode.stdlibexplore.notwellknown.maps

fun main(args: Array<String>) {

    val mapFromList = listOf(1 to 2, 2 to 3, 5 to 1).toMap()

    println(mapFromList)

    // {1=2, 2=3, 5=1}

    val dirtyData = mapOf("1" to "foo", "2" to "bar", "baz" to "qux")

    val cleanData = dirtyData
            .filterKeys { it.toIntOrNull() != null }
            .mapKeys { it.key.toInt() }

    println(cleanData)

    // {1=foo, 2=bar}

    val map = mapOf("foo" to "bar", "baz" to "qux")

    println(map.asIterable())

    // [foo=bar, baz=qux] <-- list of Pairs

}

package org.codetome.kotlincode.stdlibexplore.notwellknown.honorable

fun main(args: Array<String>) {

    (0 until 10).forEach {
        print("$it ")
    }
    // 0 1 2 3 4 5 6 7 8 9

    (0 .. 10).forEach {
        print("$it ")
    }
    // 0 1 2 3 4 5 6 7 8 9 10

    (10 downTo 0).forEach {
        print("$it ")
    }
    // 10 9 8 7 6 5 4 3 2 1 0

    (10 downTo 0 step 2).forEach {
        print("$it ")
    }
    // 10 8 6 4 2 0

}

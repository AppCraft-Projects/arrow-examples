package org.codetome.kotlincode.stdlibexplore.pitfalls

import java.util.*
import java.util.concurrent.ConcurrentHashMap

fun main(args: Array<String>) {

    val queue: Queue<String> = LinkedList()

    queue.peek().toInt() // throws NPE but the compiler will not complain

}

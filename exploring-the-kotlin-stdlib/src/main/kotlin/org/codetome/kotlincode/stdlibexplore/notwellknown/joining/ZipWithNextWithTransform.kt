package org.codetome.kotlincode.stdlibexplore.notwellknown.joining

fun main(args: Array<String>) {

    data class Node(val value: String, val edges: List<String>)

    val nodes = listOf("A", "B", "C", "D")

    // same as zipWithNext but you can specify your own result class

    val zipWithNext = nodes.zipWithNext { node, edge -> Node(node, listOf(edge))}

    println(zipWithNext)
    // [Node(value=A, edges=[B]), Node(value=B, edges=[C]), Node(value=C, edges=[D])]

}

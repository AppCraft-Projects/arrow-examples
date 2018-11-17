@file:Suppress("unused")

package org.hexworks.kotlincode.libdev.example06

import org.hexworks.kotlincode.libdev.example05.Subscription

fun <T: Subscription> MutableList<T>.cancelAll() {
    forEach {
        it.cancel()
    }
    clear()
}

fun usage() {

    val subscriptions = mutableListOf<Subscription>()

    subscriptions.cancelAll()

}

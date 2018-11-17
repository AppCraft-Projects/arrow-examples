package org.hexworks.kotlincode.libdev.example07

import org.hexworks.kotlincode.libdev.example05.Subscription
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST", "unused")
class EventBus {

    private val subscriptions = mutableMapOf<KClass<out Any>, (Any) -> Unit>()

    inline fun <reified T : Event> subscribe(noinline callback: (T) -> Unit) {
        return subscribe(
                klass = T::class,
                callback = callback)
    }

    fun <T : Event> subscribe(klass: KClass<T>,
                              callback: (T) -> Unit) {
        subscriptions[klass] = callback as (Any) -> Unit
    }

}

package org.hexworks.kotlincode.libdev.example01

import org.hexworks.kotlincode.libdev.Container
import org.hexworks.kotlincode.libdev.PixelGraphicsImpl

@Suppress("unused", "UNUSED_PARAMETER")
class MyComponent(
        // isFocused wasn't needed after all
        val children: List<MyComponent>,
        val drawSurface: PixelGraphicsImpl) {

    fun requestFocus() {

    }

    fun clearFocus() {

    }

    // these shouldn't have been exposed
    internal fun render() {

    }

    internal fun attachTo(container: Container) {

    }
}

package org.hexworks.kotlincode.libdev.example00

import org.hexworks.kotlincode.libdev.Container
import org.hexworks.kotlincode.libdev.PixelGraphicsImpl

@Suppress("unused", "UNUSED_PARAMETER")
class MyComponent(
        val isFocused: Boolean,
        val children: List<MyComponent>,
        val drawSurface: PixelGraphicsImpl) {

    fun requestFocus() {

    }

    fun clearFocus() {

    }

    fun render() {

    }

    fun attachTo(container: Container) {

    }
}

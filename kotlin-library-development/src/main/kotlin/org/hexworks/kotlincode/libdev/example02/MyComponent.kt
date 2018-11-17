package org.hexworks.kotlincode.libdev.example02

import org.hexworks.kotlincode.libdev.Component
import org.hexworks.kotlincode.libdev.Container
import org.hexworks.kotlincode.libdev.DrawSurface

@Suppress("unused", "UNUSED_PARAMETER")
class MyComponent(
        val children: Iterable<Component>,
        val drawSurface: DrawSurface) {

    fun requestFocus() {

    }

    fun clearFocus() {

    }

    internal fun render() {

    }

    internal fun attachTo(container: Container) {

    }
}

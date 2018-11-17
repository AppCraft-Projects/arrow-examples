package org.hexworks.kotlincode.libdev.example04

import org.hexworks.kotlincode.libdev.Component
import org.hexworks.kotlincode.libdev.DrawSurface

@Suppress("unused", "UNUSED_PARAMETER")
object ComponentFactory {

    fun createComponent(children: Iterable<Component>,
                        drawSurface: DrawSurface): Component {
        return MyComponent(
                children = children,
                drawSurface = drawSurface)
    }
}
